package com.riversand.app;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.riversand.dataplatform.ps.foundation.businessobjects.BaseValue;
import com.riversand.dataplatform.ps.foundation.businessobjects.DataObject;
import com.riversand.dataplatform.ps.foundation.businessobjects.DataObjectOperationRequest;
import com.riversand.dataplatform.ps.foundation.businessobjects.builder.DataObjectOperationRequestBuilder;
import com.riversand.dataplatform.ps.foundation.search.AttributeCriterion;
import com.riversand.dataplatform.ps.foundation.search.Criterion;
import com.riversand.dataplatform.ps.foundation.search.Query;
import com.riversand.dataplatform.ps.foundation.serviceclient.StandardDataplatformService;
import com.riversand.dataplatform.ps.foundation.utility.GsonBuilder;

import java.util.List;


public class PublishApplicationGroupWithCatKeys {
    public static void main(String[] args) {

        List<String> catalogKeys = List.of("130376-USA_BCKM_15174","130376-USA_BCKM_19837","130376-USA_BCKM_7412","130376-USA_BCKM_7556","130376-USA_BCVC_7212","130376-USA_BDDP_10214","130376-USA_BDDP_10488","130376-USA_BDDP_11340","130376-USA_BDDP_12027","130376-USA_BDDP_14832","130376-USA_BDDP_14855","130376-USA_BDDP_15563","130376-USA_BDDP_23507","130376-USA_BDDP_4188","130376-USA_BDDP_59002","130376-USA_BDDP_6124","130376-USA_BDDP_6224","130376-USA_BDDP_6256","130376-USA_BDDP_7054","130376-USA_BDDP_7060","130376-USA_BDDP_7064","130376-USA_BDDP_7096","130376-USA_BDDP_7108","130376-USA_BDDP_7120","130376-USA_BDDP_7136","130376-USA_BDDP_7166","130376-USA_BDDP_7212","130376-USA_BDDP_7228","130376-USA_BDDP_7232","130376-USA_BFLW_10009","130376-USA_BFLW_10039","130376-USA_BFLW_10040","130376-USA_BFLW_10051","130376-USA_BFLW_10054","130376-USA_BFLW_10055","130376-USA_BFLW_10061","130376-USA_BFLW_10065","130376-USA_BFLW_10066","130376-USA_BFLW_10068","130376-USA_BFLW_10070","130376-USA_BFLW_10129","130376-USA_BFLW_10147","130376-USA_BFLW_10177","130376-USA_BFLW_10217","130376-USA_BFLW_10220","130376-USA_BFLW_1024","130376-USA_BFLW_10321","130376-USA_BFLW_10323","130376-USA_BFLW_10353","130376-USA_BFLW_1036","130376-USA_BFLW_10401","130376-USA_BFLW_10404","130376-USA_BFLW_10406","130376-USA_BFLW_10416","130376-USA_BFLW_10431","130376-USA_BFLW_10433","130376-USA_BFLW_10437","130376-USA_BFLW_10444","130376-USA_BFLW_10473","130376-USA_BFLW_1048","130376-USA_BFLW_10485","130376-USA_BFLW_10488","130376-USA_BFLW_10507","130376-USA_BFLW_10516","130376-USA_BFLW_10527","130376-USA_BFLW_10530","130376-USA_BFLW_10562","130376-USA_BFLW_10563","130376-USA_BFLW_10580","130376-USA_BFLW_10585","130376-USA_BFLW_10586","130376-USA_BFLW_4172","130376-USA_BFLW_4188","130376-USA_BFLW_4252","130376-USA_BFLW_4436","130376-USA_BFLW_4472","130376-USA_BFLW_4484","130376-USA_BFLW_4492","130376-USA_BFLW_4512","130376-USA_BFLW_4516","130376-USA_BFLW_45814","130376-USA_BFLW_4584","130376-USA_BFLW_45966","130376-USA_BFLW_4600","130376-USA_BFLW_46117","130376-USA_BFLW_46142","130376-USA_BFLW_4616","130376-USA_BFLW_46178","130376-USA_BFLW_46181","130376-USA_BFLW_46225","130376-USA_BFLW_46345","130376-USA_BFLW_46349","130376-USA_BFLW_46355","130376-USA_BFLW_46487","130376-USA_BFLW_46511","130376-USA_BFLW_46722","130376-USA_BFLW_46723","130376-USA_BFLW_46727","130376-USA_BFLW_46758","130376-USA_BFLW_46814","130376-USA_BFLW_46877","130376-USA_BFLW_46884","130376-USA_BFLW_4700","130376-USA_BFLW_47544","130376-USA_BFLW_47545","130376-USA_BFLW_47754","130376-USA_BFLW_47787","130376-USA_BFLW_47788","130376-USA_BFLW_48056","130376-USA_BFLW_48160","130376-USA_BFLW_4832","130376-USA_BFLW_48522","130376-USA_BFLW_4856","130376-USA_BFLW_48613","130376-USA_BFLW_4884","130376-USA_BFLW_49218","130376-USA_BFLW_49287","130376-USA_BFLW_49432","130376-USA_BFLW_49933","130376-USA_BFLW_50019","130376-USA_BFLW_5020","130376-USA_BFLW_5028","130376-USA_BFLW_5052","130376-USA_BFLW_5056","130376-USA_BFLW_5060","130376-USA_BFLW_50619","130376-USA_BFLW_50757","130376-USA_BFLW_5108","130376-USA_BFLW_5132","130376-USA_BFLW_5136","130376-USA_BFLW_51456","130376-USA_BFLW_51460","130376-USA_BFLW_51500","130376-USA_BFLW_51507","130376-USA_BFLW_51650","130376-USA_BFLW_5177","130376-USA_BFLW_51861","130376-USA_BFLW_54924","130376-USA_BFLW_55399","130376-USA_BFLW_55614","130376-USA_BFLW_55913","130376-USA_BFLW_55920","130376-USA_BFLW_56859","130376-USA_BFLW_57428","130376-USA_BFLW_5900","130376-USA_BFLW_59240","130376-USA_BFLW_59819","130376-USA_BFLW_6124","130376-USA_BFLW_6128","130376-USA_BFLW_6132","130376-USA_BFLW_6200","130376-USA_BFLW_6212","130376-USA_BFLW_6224","130376-USA_BFLW_62610","130376-USA_BFLW_6268","130376-USA_BFLW_6272","130376-USA_BFLW_62955","130376-USA_BFLW_6316","130376-USA_BFLW_63213","130376-USA_BFLW_63214","130376-USA_BFLW_63217","130376-USA_BFLW_6352","130376-USA_BFLW_6356","130376-USA_BFLW_64442","130376-USA_BFLW_6472","130376-USA_BFLW_6557","130376-USA_BFLW_6560","130376-USA_BFLW_6564","130376-USA_BFLW_67844","130376-USA_BFLW_6864","130376-USA_BFLW_6884","130376-USA_BFLW_6892","130376-USA_BFLW_6916","130376-USA_BFLW_7056","130376-USA_BFLW_7060","130376-USA_BFLW_7072","130376-USA_BFLW_7092","130376-USA_BFLW_7096","130376-USA_BFLW_7144","130376-USA_BFLW_7212","130376-USA_BFLW_7220","130376-USA_BFLW_7228","130376-USA_BFLW_7244","130376-USA_BFLW_7256","130376-USA_BFLW_7272","130376-USA_BFLW_7274","130376-USA_BFLW_7280","130376-USA_BFLW_7290","130376-USA_BFLW_7300","130376-USA_BFLW_7328","130376-USA_BFLW_7332","130376-USA_BFLW_7364","130376-USA_BFLW_7368","130376-USA_BFLW_7378","130376-USA_BFLW_7380","130376-USA_BFLW_7384","130376-USA_BFLW_7392","130376-USA_BFLW_7397","130376-USA_BFLW_7403","130376-USA_BFLW_7407","130376-USA_BFLW_7412","130376-USA_BFLW_7415","130376-USA_BFLW_7418","130376-USA_BFLW_7420","130376-USA_BFLW_7428","130376-USA_BFLW_7432","130376-USA_BFLW_7452","130376-USA_BFLW_7460","130376-USA_BFLW_7484","130376-USA_BFLW_7488","130376-USA_BFLW_7496","130376-USA_BFLW_7500","130376-USA_BFLW_7504","130376-USA_BFLW_7528","130376-USA_BFLW_7532","130376-USA_BFLW_7544","130376-USA_BFLW_7556","130376-USA_BFLW_7564","130376-USA_BFLW_7572","130376-USA_BFLW_7580","130376-USA_BFLW_7584","130376-USA_BFLW_7600","130376-USA_BFLW_7604","130376-USA_BFLW_7608","130376-USA_BFLW_7620","130376-USA_BFLW_7624","130376-USA_BFLW_7648","130376-USA_BFLW_7668","130376-USA_BFLW_7676","130376-USA_BFLW_7680","130376-USA_BFLW_7948","130376-USA_BFLW_8052","130376-USA_BFLW_8076","130376-USA_BFLW_8084","130376-USA_BFLW_8088","130376-USA_BFLW_8112","130376-USA_BFLW_8300","130376-USA_BFLW_8312","130376-USA_BFLW_8332","130376-USA_BFLW_8360","130376-USA_BFLW_8364","130376-USA_BFLW_8368","130376-USA_BFLW_8416","130376-USA_BFLW_8440","130376-USA_BFLW_8752","130376-USA_BFLW_8754","130376-USA_BFLW_8756","130376-USA_BFLW_8760","130376-USA_BFLW_8808","130376-USA_BFLW_8820","130376-USA_BFLW_8824","130376-USA_BFLW_8838","130376-USA_BFLW_8840","130376-USA_BFLW_8848","130376-USA_BFLW_8852","130376-USA_BFLW_8856","130376-USA_BFLW_8860","130376-USA_BFLW_8905","130376-USA_BJDL_10278","130376-USA_BJDL_10314","130376-USA_BJDL_10401","130376-USA_BJDL_10431","130376-USA_BJDL_10589","130376-USA_BJDL_10774","130376-USA_BJDL_13074","130376-USA_BJDL_14243","130376-USA_BJDL_14578","130376-USA_BJDL_14754","130376-USA_BJDL_15364","130376-USA_BJDL_15544","130376-USA_BJDL_16744","130376-USA_BJDL_17857","130376-USA_BJDL_17862","130376-USA_BJDL_17894","130376-USA_BJDL_18250","130376-USA_BJDL_2412","130376-USA_BJDL_4152","130376-USA_BJDL_49641","130376-USA_BJDL_50389","130376-USA_BJDL_5236","130376-USA_BJDL_5260","130376-USA_BJDL_5292","130376-USA_BJDL_5300","130376-USA_BJDL_5328","130376-USA_BJDL_5348","130376-USA_BJDL_5404","130376-USA_BJDL_5412","130376-USA_BJDL_5424","130376-USA_BJDL_5536","130376-USA_BJDL_5540","130376-USA_BJDL_5544","130376-USA_BJDL_5564","130376-USA_BJDL_5737","130376-USA_BJDL_5744","130376-USA_BJDL_5776","130376-USA_BJDL_5848","130376-USA_BJDL_59720","130376-USA_BJDL_63214","130376-USA_BJDL_6472","130376-USA_BJDL_7060","130376-USA_BJDL_7228","130376-USA_BJDL_7380","130376-USA_BJDT_10186","130376-USA_BJDT_10217","130376-USA_BJDT_10656","130376-USA_BJDT_11096","130376-USA_BJDT_13339","130376-USA_BJDT_1516","130376-USA_BJDT_15596","130376-USA_BJDT_4624","130376-USA_BJDT_8840","130376-USA_BJDT_8844","130376-USA_BJDT_8865","130376-USA_BJQJ_10186","130376-USA_BJQJ_10217","130376-USA_BJQJ_10656","130376-USA_BJQJ_11096","130376-USA_BJQJ_13339","130376-USA_BJQJ_1516","130376-USA_BJQJ_15596","130376-USA_BJQJ_4624","130376-USA_BJQJ_8840","130376-USA_BJQJ_8844","130376-USA_BJQJ_8865","130376-USA_BKMN_10009","130376-USA_BKMN_10039","130376-USA_BKMN_10040","130376-USA_BKMN_10051","130376-USA_BKMN_10054","130376-USA_BKMN_10055","130376-USA_BKMN_10061","130376-USA_BKMN_10065","130376-USA_BKMN_10066","130376-USA_BKMN_10068","130376-USA_BKMN_10070","130376-USA_BKMN_10129","130376-USA_BKMN_10147","130376-USA_BKMN_10177","130376-USA_BKMN_10217","130376-USA_BKMN_10220","130376-USA_BKMN_1024","130376-USA_BKMN_10321","130376-USA_BKMN_10323","130376-USA_BKMN_10353","130376-USA_BKMN_1036","130376-USA_BKMN_10401","130376-USA_BKMN_10404","130376-USA_BKMN_10406","130376-USA_BKMN_10416","130376-USA_BKMN_10431","130376-USA_BKMN_10433","130376-USA_BKMN_10437","130376-USA_BKMN_10444","130376-USA_BKMN_10473","130376-USA_BKMN_1048","130376-USA_BKMN_10485","130376-USA_BKMN_10488","130376-USA_BKMN_10507","130376-USA_BKMN_10516","130376-USA_BKMN_10527","130376-USA_BKMN_10530","130376-USA_BKMN_10562","130376-USA_BKMN_10563","130376-USA_BKMN_10580","130376-USA_BKMN_10585","130376-USA_BKMN_10586","130376-USA_BKMN_10589","130376-USA_BKMN_10595","130376-USA_BKMN_10603","130376-USA_BKMN_10604","130376-USA_BKMN_10605","130376-USA_BKMN_10607","130376-USA_BKMN_10626","130376-USA_BKMN_10631","130376-USA_BKMN_10634","130376-USA_BKMN_10642","130376-USA_BKMN_10659","130376-USA_BKMN_10677","130376-USA_BKMN_10715","130376-USA_BKMN_10716","130376-USA_BKMN_10721","130376-USA_BKMN_10723","130376-USA_BKMN_10737","130376-USA_BKMN_10747","130376-USA_BKMN_10750","130376-USA_BKMN_10762","130376-USA_BKMN_10881","130376-USA_BKMN_10885","130376-USA_BKMN_10893","130376-USA_BKMN_10894","130376-USA_BKMN_10896","130376-USA_BKMN_10901","130376-USA_BKMN_10905","130376-USA_BKMN_10932","130376-USA_BKMN_10934","130376-USA_BKMN_10939","130376-USA_BKMN_10942","130376-USA_BKMN_10959","130376-USA_BKMN_10964","130376-USA_BKMN_11052","130376-USA_BKMN_11061","130376-USA_BKMN_11064","130376-USA_BKMN_11074","130376-USA_BKMN_11075","130376-USA_BKMN_11082","130376-USA_BKMN_11089","130376-USA_BKMN_11090","130376-USA_BKMN_11091","130376-USA_BKMN_11097","130376-USA_BKMN_11217","130376-USA_BKMN_11223","130376-USA_BKMN_11224","130376-USA_BKMN_11226","130376-USA_BKMN_11237","130376-USA_BKMN_11238","130376-USA_BKMN_11241","130376-USA_BKMN_11246","130376-USA_BKMN_11255","130376-USA_BKMN_11268","130376-USA_BKMN_11303","130376-USA_BKMN_11318","130376-USA_BKMN_11371","130376-USA_BKMN_11373","130376-USA_BKMN_11377","130376-USA_BKMN_11436","130376-USA_BKMN_11438","130376-USA_BKMN_11444","130376-USA_BKMN_11449","130376-USA_BKMN_11453","130376-USA_BKMN_11454","130376-USA_BKMN_11457","130376-USA_BKMN_11458","130376-USA_BKMN_11472","130376-USA_BKMN_11526","130376-USA_BKMN_11573","130376-USA_BKMN_11642","130376-USA_BKMN_11668","130376-USA_BKMN_11676","130376-USA_BKMN_11694","130376-USA_BKMN_11695","130376-USA_BKMN_11696","130376-USA_BKMN_11700","130376-USA_BKMN_11701","130376-USA_BKMN_11719","130376-USA_BKMN_11720","130376-USA_BKMN_11721","130376-USA_BKMN_11725","130376-USA_BKMN_11732","130376-USA_BKMN_11798","130376-USA_BKMN_1202","130376-USA_BKMN_1212","130376-USA_BKMN_12402","130376-USA_BKMN_12412","130376-USA_BKMN_12475","130376-USA_BKMN_12503","130376-USA_BKMN_12506","130376-USA_BKMN_12554","130376-USA_BKMN_12562","130376-USA_BKMN_12568","130376-USA_BKMN_12586","130376-USA_BKMN_12588","130376-USA_BKMN_12591","130376-USA_BKMN_12616","130376-USA_BKMN_12623","130376-USA_BKMN_12632","130376-USA_BKMN_12636","130376-USA_BKMN_12637","130376-USA_BKMN_12677","130376-USA_BKMN_12707","130376-USA_BKMN_12741","130376-USA_BKMN_12946","130376-USA_BKMN_12957","130376-USA_BKMN_12967","130376-USA_BKMN_12970","130376-USA_BKMN_12982","130376-USA_BKMN_12983","130376-USA_BKMN_12984","130376-USA_BKMN_12992","130376-USA_BKMN_13028","130376-USA_BKMN_13032","130376-USA_BKMN_13060","130376-USA_BKMN_13090","130376-USA_BKMN_13103","130376-USA_BKMN_13115","130376-USA_BKMN_13116","130376-USA_BKMN_1320","130376-USA_BKMN_13212","130376-USA_BKMN_13215","130376-USA_BKMN_13222","130376-USA_BKMN_13231","130376-USA_BKMN_13274","130376-USA_BKMN_1328","130376-USA_BKMN_13363","130376-USA_BKMN_13498","130376-USA_BKMN_13523","130376-USA_BKMN_13582","130376-USA_BKMN_13587","130376-USA_BKMN_13589","130376-USA_BKMN_1360","130376-USA_BKMN_13610","130376-USA_BKMN_13617","130376-USA_BKMN_13661","130376-USA_BKMN_13662","130376-USA_BKMN_13663","130376-USA_BKMN_13664","130376-USA_BKMN_13666","130376-USA_BKMN_13669","130376-USA_BKMN_13670","130376-USA_BKMN_13671","130376-USA_BKMN_13673","130376-USA_BKMN_13675","130376-USA_BKMN_13676","130376-USA_BKMN_13677","130376-USA_BKMN_13679","130376-USA_BKMN_13680","130376-USA_BKMN_13699","130376-USA_BKMN_13708","130376-USA_BKMN_13716","130376-USA_BKMN_13717","130376-USA_BKMN_13724","130376-USA_BKMN_13736","130376-USA_BKMN_13777","130376-USA_BKMN_1380","130376-USA_BKMN_13821","130376-USA_BKMN_13823","130376-USA_BKMN_1384","130376-USA_BKMN_1388","130376-USA_BKMN_1392","130376-USA_BKMN_1396","130376-USA_BKMN_13962","130376-USA_BKMN_13977","130376-USA_BKMN_13999","130376-USA_BKMN_14024","130376-USA_BKMN_14028","130376-USA_BKMN_14034","130376-USA_BKMN_14087","130376-USA_BKMN_14088","130376-USA_BKMN_14093","130376-USA_BKMN_14099","130376-USA_BKMN_14101","130376-USA_BKMN_14103","130376-USA_BKMN_14112","130376-USA_BKMN_14114","130376-USA_BKMN_14122","130376-USA_BKMN_14143","130376-USA_BKMN_1416","130376-USA_BKMN_14172","130376-USA_BKMN_14174","130376-USA_BKMN_14180","130376-USA_BKMN_14202","130376-USA_BKMN_1421","130376-USA_BKMN_14226","130376-USA_BKMN_1425","130376-USA_BKMN_1426","130376-USA_BKMN_1427","130376-USA_BKMN_1431","130376-USA_BKMN_14347","130376-USA_BKMN_14353","130376-USA_BKMN_1440","130376-USA_BKMN_14432","130376-USA_BKMN_14434","130376-USA_BKMN_14494","130376-USA_BKMN_1456","130376-USA_BKMN_14593","130376-USA_BKMN_1476","130376-USA_BKMN_14788","130376-USA_BKMN_14837","130376-USA_BKMN_1484","130376-USA_BKMN_14842","130376-USA_BKMN_14871","130376-USA_BKMN_14876","130376-USA_BKMN_14878","130376-USA_BKMN_1488","130376-USA_BKMN_14892","130376-USA_BKMN_14906","130376-USA_BKMN_14921","130376-USA_BKMN_14951","130376-USA_BKMN_1496","130376-USA_BKMN_14999","130376-USA_BKMN_15015","130376-USA_BKMN_15029","130376-USA_BKMN_1504","130376-USA_BKMN_15056","130376-USA_BKMN_15120","130376-USA_BKMN_15128","130376-USA_BKMN_15130","130376-USA_BKMN_15133","130376-USA_BKMN_15134","130376-USA_BKMN_15136","130376-USA_BKMN_15138","130376-USA_BKMN_15140","130376-USA_BKMN_15143","130376-USA_BKMN_15157","130376-USA_BKMN_15158","130376-USA_BKMN_15159","130376-USA_BKMN_15161","130376-USA_BKMN_15162","130376-USA_BKMN_15163","130376-USA_BKMN_15166","130376-USA_BKMN_15167","130376-USA_BKMN_15176","130376-USA_BKMN_15177","130376-USA_BKMN_15178","130376-USA_BKMN_15182","130376-USA_BKMN_15202","130376-USA_BKMN_15203","130376-USA_BKMN_15204","130376-USA_BKMN_15205","130376-USA_BKMN_15206","130376-USA_BKMN_15208","130376-USA_BKMN_15215","130376-USA_BKMN_15223","130376-USA_BKMN_15258","130376-USA_BKMN_15303","130376-USA_BKMN_15316","130376-USA_BKMN_15322","130376-USA_BKMN_15563","130376-USA_BKMN_15571","130376-USA_BKMN_15598","130376-USA_BKMN_15599","130376-USA_BKMN_15613","130376-USA_BKMN_15619","130376-USA_BKMN_15623","130376-USA_BKMN_15624","130376-USA_BKMN_15625","130376-USA_BKMN_15714","130376-USA_BKMN_1572","130376-USA_BKMN_15735","130376-USA_BKMN_15741","130376-USA_BKMN_15747","130376-USA_BKMN_15753","130376-USA_BKMN_1576","130376-USA_BKMN_15895","130376-USA_BKMN_16045","130376-USA_BKMN_16046","130376-USA_BKMN_16047","130376-USA_BKMN_16048","130376-USA_BKMN_16049","130376-USA_BKMN_16050","130376-USA_BKMN_16052","130376-USA_BKMN_16053","130376-USA_BKMN_16054","130376-USA_BKMN_16056","130376-USA_BKMN_16057","130376-USA_BKMN_16061","130376-USA_BKMN_16167","130376-USA_BKMN_16215","130376-USA_BKMN_16345","130376-USA_BKMN_16360","130376-USA_BKMN_16372","130376-USA_BKMN_16373","130376-USA_BKMN_16403","130376-USA_BKMN_16468","130376-USA_BKMN_16553","130376-USA_BKMN_16658","130376-USA_BKMN_16717","130376-USA_BKMN_1672","130376-USA_BKMN_16755","130376-USA_BKMN_16822","130376-USA_BKMN_1696","130376-USA_BKMN_17034","130376-USA_BKMN_17085","130376-USA_BKMN_17087","130376-USA_BKMN_17096","130376-USA_BKMN_17125","130376-USA_BKMN_17452","130376-USA_BKMN_17721","130376-USA_BKMN_17727","130376-USA_BKMN_17742","130376-USA_BKMN_17827","130376-USA_BKMN_17845","130376-USA_BKMN_17968","130376-USA_BKMN_17972","130376-USA_BKMN_18242","130376-USA_BKMN_18481","130376-USA_BKMN_18616","130376-USA_BKMN_18617","130376-USA_BKMN_18618","130376-USA_BKMN_18622","130376-USA_BKMN_18623","130376-USA_BKMN_18625","130376-USA_BKMN_18626","130376-USA_BKMN_18628","130376-USA_BKMN_18630","130376-USA_BKMN_18631","130376-USA_BKMN_18633","130376-USA_BKMN_18634","130376-USA_BKMN_18635","130376-USA_BKMN_18637","130376-USA_BKMN_18638","130376-USA_BKMN_18639","130376-USA_BKMN_18641","130376-USA_BKMN_18642","130376-USA_BKMN_18647","130376-USA_BKMN_18654","130376-USA_BKMN_1868","130376-USA_BKMN_18703","130376-USA_BKMN_18720","130376-USA_BKMN_18725","130376-USA_BKMN_18786","130376-USA_BKMN_18796","130376-USA_BKMN_18797","130376-USA_BKMN_1884","130376-USA_BKMN_19121","130376-USA_BKMN_19152","130376-USA_BKMN_19262","130376-USA_BKMN_19330","130376-USA_BKMN_19414","130376-USA_BKMN_19415","130376-USA_BKMN_19439","130376-USA_BKMN_19446","130376-USA_BKMN_19488","130376-USA_BKMN_19495","130376-USA_BKMN_19498","130376-USA_BKMN_19538","130376-USA_BKMN_19541","130376-USA_BKMN_1988","130376-USA_BKMN_1993","130376-USA_BKMN_19954","130376-USA_BKMN_20064","130376-USA_BKMN_20465","130376-USA_BKMN_20466","130376-USA_BKMN_20474","130376-USA_BKMN_20526","130376-USA_BKMN_20542","130376-USA_BKMN_2068","130376-USA_BKMN_20839","130376-USA_BKMN_20848","130376-USA_BKMN_20959","130376-USA_BKMN_20965","130376-USA_BKMN_20966","130376-USA_BKMN_20971","130376-USA_BKMN_20972","130376-USA_BKMN_20974","130376-USA_BKMN_20977","130376-USA_BKMN_20978","130376-USA_BKMN_20979","130376-USA_BKMN_20980","130376-USA_BKMN_20981","130376-USA_BKMN_20984","130376-USA_BKMN_20987","130376-USA_BKMN_20990","130376-USA_BKMN_21005","130376-USA_BKMN_21006","130376-USA_BKMN_21016","130376-USA_BKMN_21020","130376-USA_BKMN_21021","130376-USA_BKMN_21022","130376-USA_BKMN_21030","130376-USA_BKMN_21031","130376-USA_BKMN_21032","130376-USA_BKMN_21034","130376-USA_BKMN_21035","130376-USA_BKMN_21042","130376-USA_BKMN_21043","130376-USA_BKMN_21050","130376-USA_BKMN_21051","130376-USA_BKMN_21052","130376-USA_BKMN_21053","130376-USA_BKMN_21455","130376-USA_BKMN_21597","130376-USA_BKMN_21600","130376-USA_BKMN_21603","130376-USA_BKMN_2172","130376-USA_BKMN_2176","130376-USA_BKMN_21807","130376-USA_BKMN_21808","130376-USA_BKMN_21811","130376-USA_BKMN_21887","130376-USA_BKMN_21898","130376-USA_BKMN_22082","130376-USA_BKMN_22438","130376-USA_BKMN_23411","130376-USA_BKMN_23450","130376-USA_BKMN_23470","130376-USA_BKMN_23580","130376-USA_BKMN_2392","130376-USA_BKMN_2404","130376-USA_BKMN_2580","130376-USA_BKMN_2668","130376-USA_BKMN_2712","130376-USA_BKMN_2732","130376-USA_BKMN_2764","130376-USA_BKMN_2796","130376-USA_BKMN_2800","130376-USA_BKMN_2816","130376-USA_BKMN_2876","130376-USA_BKMN_3468","130376-USA_BKMN_3804","130376-USA_BKMN_4152","130376-USA_BKMN_4153","130376-USA_BKMN_4156","130376-USA_BKMN_4160","130376-USA_BKMN_4168","130376-USA_BKMN_4172","130376-USA_BKMN_4188","130376-USA_BKMN_4252","130376-USA_BKMN_4436","130376-USA_BKMN_4472","130376-USA_BKMN_4484","130376-USA_BKMN_4492","130376-USA_BKMN_4512","130376-USA_BKMN_4516","130376-USA_BKMN_45814","130376-USA_BKMN_4584","130376-USA_BKMN_45966","130376-USA_BKMN_4600","130376-USA_BKMN_46117","130376-USA_BKMN_46142","130376-USA_BKMN_4616","130376-USA_BKMN_46178","130376-USA_BKMN_46181","130376-USA_BKMN_46225","130376-USA_BKMN_46345","130376-USA_BKMN_46349","130376-USA_BKMN_46355","130376-USA_BKMN_46487","130376-USA_BKMN_46511","130376-USA_BKMN_46722","130376-USA_BKMN_46723","130376-USA_BKMN_46727","130376-USA_BKMN_46758","130376-USA_BKMN_46814","130376-USA_BKMN_46877","130376-USA_BKMN_46884","130376-USA_BKMN_4700","130376-USA_BKMN_47544","130376-USA_BKMN_47545","130376-USA_BKMN_47754","130376-USA_BKMN_47787","130376-USA_BKMN_47788","130376-USA_BKMN_48056","130376-USA_BKMN_48160","130376-USA_BKMN_4832","130376-USA_BKMN_48522","130376-USA_BKMN_4856","130376-USA_BKMN_48613","130376-USA_BKMN_4884","130376-USA_BKMN_49218","130376-USA_BKMN_49287","130376-USA_BKMN_49432","130376-USA_BKMN_49933","130376-USA_BKMN_50019","130376-USA_BKMN_5020","130376-USA_BKMN_5028","130376-USA_BKMN_5052","130376-USA_BKMN_5056","130376-USA_BKMN_5060","130376-USA_BKMN_50619","130376-USA_BKMN_50757","130376-USA_BKMN_5108","130376-USA_BKMN_5132","130376-USA_BKMN_5136","130376-USA_BKMN_51456","130376-USA_BKMN_51460","130376-USA_BKMN_51500","130376-USA_BKMN_51507","130376-USA_BKMN_51650","130376-USA_BKMN_5177","130376-USA_BKMN_51861","130376-USA_BKMN_54924","130376-USA_BKMN_55399","130376-USA_BKMN_55614","130376-USA_BKMN_55913","130376-USA_BKMN_55920","130376-USA_BKMN_56859","130376-USA_BKMN_57428","130376-USA_BKMN_5900","130376-USA_BKMN_59240","130376-USA_BKMN_59819","130376-USA_BKMN_6124","130376-USA_BKMN_6128","130376-USA_BKMN_6132","130376-USA_BKMN_6200","130376-USA_BKMN_6212","130376-USA_BKMN_6224","130376-USA_BKMN_62610","130376-USA_BKMN_6268","130376-USA_BKMN_6272","130376-USA_BKMN_62955","130376-USA_BKMN_6316","130376-USA_BKMN_63213","130376-USA_BKMN_63214","130376-USA_BKMN_63217","130376-USA_BKMN_6352","130376-USA_BKMN_6356","130376-USA_BKMN_64442","130376-USA_BKMN_6472","130376-USA_BKMN_6557","130376-USA_BKMN_6560","130376-USA_BKMN_6564","130376-USA_BKMN_67844","130376-USA_BKMN_6864","130376-USA_BKMN_6884","130376-USA_BKMN_6892","130376-USA_BKMN_6916","130376-USA_BKMN_7056","130376-USA_BKMN_7060","130376-USA_BKMN_7072","130376-USA_BKMN_7092","130376-USA_BKMN_7096","130376-USA_BKMN_7144","130376-USA_BKMN_7212","130376-USA_BKMN_7220","130376-USA_BKMN_7228","130376-USA_BKMN_7244","130376-USA_BKMN_7256","130376-USA_BKMN_7272","130376-USA_BKMN_7274","130376-USA_BKMN_7280","130376-USA_BKMN_7290","130376-USA_BKMN_7300","130376-USA_BKMN_7328","130376-USA_BKMN_7332","130376-USA_BKMN_7364","130376-USA_BKMN_7368","130376-USA_BKMN_7378","130376-USA_BKMN_7380","130376-USA_BKMN_7384","130376-USA_BKMN_7392","130376-USA_BKMN_7397","130376-USA_BKMN_7403","130376-USA_BKMN_7407","130376-USA_BKMN_7412","130376-USA_BKMN_7415","130376-USA_BKMN_7418","130376-USA_BKMN_7420","130376-USA_BKMN_7428","130376-USA_BKMN_7432","130376-USA_BKMN_7452","130376-USA_BKMN_7460","130376-USA_BKMN_7484","130376-USA_BKMN_7488","130376-USA_BKMN_7496","130376-USA_BKMN_7500","130376-USA_BKMN_7504","130376-USA_BKMN_7528","130376-USA_BKMN_7532","130376-USA_BKMN_7544","130376-USA_BKMN_7556","130376-USA_BKMN_7564","130376-USA_BKMN_7572","130376-USA_BKMN_7580","130376-USA_BKMN_7584","130376-USA_BKMN_7600","130376-USA_BKMN_7604","130376-USA_BKMN_7608","130376-USA_BKMN_7620","130376-USA_BKMN_7624","130376-USA_BKMN_7648","130376-USA_BKMN_7668","130376-USA_BKMN_7676","130376-USA_BKMN_7680","130376-USA_BKMN_7948","130376-USA_BKMN_8052","130376-USA_BKMN_8076","130376-USA_BKMN_8084","130376-USA_BKMN_8088","130376-USA_BKMN_8112","130376-USA_BKMN_8300","130376-USA_BKMN_8312","130376-USA_BKMN_8332","130376-USA_BKMN_8360","130376-USA_BKMN_8364","130376-USA_BKMN_8368","130376-USA_BKMN_8416","130376-USA_BKMN_8440","130376-USA_BKMN_8752","130376-USA_BKMN_8754","130376-USA_BKMN_8756","130376-USA_BKMN_8760","130376-USA_BKMN_8808","130376-USA_BKMN_8820","130376-USA_BKMN_8824","130376-USA_BKMN_8838","130376-USA_BKMN_8840","130376-USA_BKMN_8848","130376-USA_BKMN_8852","130376-USA_BKMN_8856","130376-USA_BKMN_8860","130376-USA_BKMN_8905","130376-USA_CFHH_6864","130376-USA_DFXS_10003","130376-USA_DFXS_10007","130376-USA_DFXS_10012","130376-USA_DFXS_10021","130376-USA_DFXS_10023","130376-USA_DFXS_10029","130376-USA_DFXS_10038","130376-USA_DFXS_10039","130376-USA_DFXS_10040","130376-USA_DFXS_10051","130376-USA_DFXS_10054","130376-USA_DFXS_10063","130376-USA_DFXS_10064","130376-USA_DFXS_10065","130376-USA_DFXS_10066","130376-USA_DFXS_10068","130376-USA_DFXS_10070","130376-USA_DFXS_10129","130376-USA_DFXS_10147");
        for (List<String> keys : Lists.partition(catalogKeys,10)){
            JsonObject query = createQuery(keys);
            JsonObject response = RdpApiHelper.queryRdp(StandardDataplatformService.BULK_ENTITY,"createtask",query.toString());
            System.out.println(query);
            System.out.println(response.getAsJsonObject("response").getAsJsonPrimitive("status").getAsString());
        }
    }

    private static JsonObject createQuery(List<String> catalogKeys) {
        DataObjectOperationRequest dataObjectOperationRequest = DataObjectOperationRequestBuilder.build();
        Query query = dataObjectOperationRequest.getQuery();
        AttributeCriterion catalogKeyCriterion = new AttributeCriterion("catalogkey");
        catalogKeyCriterion.setMultiValueCriterion(Criterion.Operator.EXACTS, Criterion.Type.STRING, catalogKeys);
        query.getAttributesCriterion().add(catalogKeyCriterion);
        query.addDataObjectType("applicationgroup");
        DataObject dataObject = new DataObject();
        dataObject.getAttributes().add("syslifecyclestage","Published", BaseValue.Type.STRING,"en-US");
        JsonObject queryOb = convertToJson(dataObjectOperationRequest.toJson());
        dataObjectOperationRequest.setDataObject(dataObject);
        queryOb.getAsJsonObject("params").addProperty("operationType","inboundService");
        queryOb.getAsJsonObject("params").addProperty("taskType","process-query");
        queryOb.getAsJsonObject("params").add("data",dataObject.getData());
        return queryOb;
    }
    private static JsonObject convertToJson(String jsonString) {
        return GsonBuilder.getGsonInstance().fromJson(jsonString, JsonObject.class);
    }
}