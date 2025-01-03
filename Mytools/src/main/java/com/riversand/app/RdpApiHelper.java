package com.riversand.app;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.riversand.batch.util.config.Config;
import com.riversand.dataplatform.ps.foundation.serviceclient.StandardDataplatformService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.riversand.dataplatform.ps.foundation.utility.GlobalConstants.SYSTEM_USER;

public class RdpApiHelper {
    private static final Logger logger = LogManager.getLogger(RdpApiHelper.class);
    public static final String X_RDP_USERID = "x-rdp-userId";
    public static final String X_RDP_CLIENTID = "x-rdp-clientId";
    public static final String X_RDP_APPID = "x-rdp-appId";

    public static JsonObject queryRdp(StandardDataplatformService standardRDPService, String operation, String query) {
        HttpURLConnection con = null;
        try {
            URL url = new URL(getRSEndpoint(standardRDPService.getServiceName(), operation, Config.Tenant));
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
        } catch (IOException e) {
            logger.error(e);
        }
        if (con != null) {

            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty(X_RDP_USERID, SYSTEM_USER);
            con.setRequestProperty(X_RDP_CLIENTID, "rdpclient");
            con.setRequestProperty(X_RDP_APPID, Config.AppID);
            con.setDoOutput(true);

            JsonObject queryResponse = null;
            int count = 0;
            while (count < 2) {
                count++;
                try (OutputStream outputStream = con.getOutputStream()) {
                    outputStream.write(query.getBytes(StandardCharsets.UTF_8));
                    if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        logger.warn("Netty Failed with the error code : {}, for the request : {}",
                                con.getResponseCode(), query);
                    }
                    return readRDPResponse(con);

                } catch (Exception ex) {
                    if (count >= 2) {
                        logger.error(String.format("Netty Failed with the socketTimeoutException , for the request : (%s) ",
                                query), ex);
                    } else {
                        logger.warn("Retry Count {} Max RetryCount: {}", count, 2);
                    }
                }
            }
            return queryResponse;
        }
        return null;
    }

    private static JsonObject readRDPResponse(HttpURLConnection con) throws IOException {
        JsonObject queryResponse;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            queryResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
        }
        return queryResponse;
    }

    public static String getRSEndpoint(String endpoint, String service, String tenant) {
        return String.format("http://%s:%s/%s/api/%s/%s",
                Config.Host, Config.Port, tenant, endpoint, service);
    }
}
