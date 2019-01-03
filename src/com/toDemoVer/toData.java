package com.toDemoVer;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.db.DBConn;
public class toData {
	@SuppressWarnings("unchecked")
	public static void handleExhi(String srcUpload,String toUpload){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erAudio = "",erThumbnail = "",erInThum = "",erUpload = ""; 
		long index = 0l;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM `res_exhibition_room` where ER_Code = 'CLS0500300000078' or ER_Code = 'CLS0500300000079' or ER_Code = 'CLS0500300000080' or ER_Code = 'CLS0500300000081' or ER_Code = 'CLS0500300000082' or ER_Code = 'CLS0500300000083' or ER_Code = 'CLS0500300000084' or ER_Code = 'CLS0500300000085' or ER_Code = 'CLS0500300000086' or ER_Code = 'CLS0500300000087' or ER_Code = 'CLS0500300000088' or ER_Code = 'CLS0500300000089' or ER_Code = 'CLS0500300000090' or ER_Code = 'CLS0500300000091' or ER_Code = 'CLS0500300000092' or ER_Code = 'CLS0500300000093' or ER_Code = 'CLS0500500000233' or ER_Code = 'CLS0500500000234' or ER_Code = 'CLS0500500000235' or ER_Code = 'CLS0500000000317' or ER_Code = 'CLS0500000000318' or ER_Code = 'CLS0500000000319' or ER_Code = 'CLS0500000000320' or ER_Code = 'CLS0500000000321' or ER_Code = 'CLS0500000000322' or ER_Code = 'CLS0500000000323' or ER_Code = 'CLS0500300000317' or ER_Code = 'CLS0500300000318' or ER_Code = 'CLS0500300000319' or ER_Code = 'CLS0500300000320' or ER_Code = 'CLS0500300000321' or ER_Code = 'CLS0500300000323' or ER_Code = 'CLS0500300000324' or ER_Code = 'CLS0500300000246' or ER_Code = 'CLS0500300000247' or ER_Code = 'CLS0500300000252' or ER_Code = 'CLS0500100000400' or ER_Code = 'CLS0500100000399' or ER_Code = 'CLS0500100000395' or ER_Code = 'CLS0500100000394' or ER_Code = 'CLS0500100000392' or ER_Code = 'CLS0500100000375' or ER_Code = 'CLS0500100000383' or ER_Code = 'CLS0500100000384' or ER_Code = 'CLS0500200000001' or ER_Code = 'CLS0500200000002' or ER_Code = 'CLS0500200000003' or ER_Code = 'CLS0500200000005' or ER_Code = 'CLS0500200000006' or ER_Code = 'CLS0500200000015' or ER_Code = 'CLS0500200000018' or ER_Code = 'CLS0500200000019' or ER_Code = 'CLS0500200000020' or ER_Code = 'CLS0500200000021' or ER_Code = 'CLS0500200000022' or ER_Code = 'CLS0500200000023' or ER_Code = 'CLS0500500000586' or ER_Code = 'CLS0500500000587' or ER_Code = 'CLS0500100000152' or ER_Code = 'CLS0500100000151' or ER_Code = 'CLS0500000001061' or ER_Code = 'CLS0500400000008' or ER_Code = 'CLS0500400000009' or ER_Code = 'CLS0500400000012' or ER_Code = 'CLS0500400000013' or ER_Code = 'CLS0500400000024' or ER_Code = 'CLS0500400000025' or ER_Code = 'CLS0500200000030' or ER_Code = 'CLS0500200000031' or ER_Code = 'CLS0500200000032' or ER_Code = 'CLS0500200000033' or ER_Code = 'CLS0500200000034' or ER_Code = 'CLS0500200000036' or ER_Code = 'CLS0500500000593' or ER_Code = 'CLS0500500000594' or ER_Code = 'CLS0500200000037' or ER_Code = 'CLS0500200000038' or ER_Code = 'CLS0500200000039' or ER_Code = 'CLS0500200000040' or ER_Code = 'CLS0500200000058' or ER_Code = 'CLS0500200000059' or ER_Code = 'CLS0500200000070' or ER_Code = 'CLS0500200000071' or ER_Code = 'CLS0500200000072' or ER_Code = 'CLS0500200000073' or ER_Code = 'CLS0500200000074' or ER_Code = 'CLS0500200000089' or ER_Code = 'CLS0500200000090' or ER_Code = 'CLS0500200000091' or ER_Code = 'CLS0500200000092' or ER_Code = 'CLS0500200000093' or ER_Code = 'CLS0500500000610' or ER_Code = 'CLS0500500000611' or ER_Code = 'CLS0500500000613' or ER_Code = 'CLS0500000000964' or ER_Code = 'CLS0200000000043' or ER_Code = 'CLS0200000005941' or ER_Code = 'CLS0200000005941' or ER_Code = 'CLS0200000000777' or ER_Code = 'CLS0200000000984' or ER_Code = 'CLS0200000001457' or ER_Code = 'CLS0200000001458' or ER_Code = 'CLS0200000001459' or ER_Code = 'CLS0200000001460' or ER_Code = 'CLS0200000001461' or ER_Code = 'CLS0200000001462' or ER_Code = 'CLS0200000001463' or ER_Code = 'CLS0200000001464' or ER_Code = 'CLS0200000001465' or ER_Code = 'CLS0200000001466' or ER_Code = 'CLS0200000001467' or ER_Code = 'CLS0200000001468' or ER_Code = 'CLS0200000000043' or ER_Code = 'CLS0200000000053' or ER_Code = 'CLS0400000001396' or ER_Code = 'CLS0400000001397' or ER_Code = 'CLS0400000001398' or ER_Code = 'CLS0500300000060' or ER_Code = 'CLS0500300000061' or ER_Code = 'CLS0500300000063' or ER_Code = 'CLS0500300000064' or ER_Code = 'CLS0500300000065' or ER_Code = 'CLS0500300000346' or ER_Code = 'CLS0500300000094' or ER_Code = 'CLS0500300000095' or ER_Code = 'CLS0500300000096' or ER_Code = 'CLS0500300000097' or ER_Code = 'CLS0500300000098' or ER_Code = 'CLS0500300000099' or ER_Code = 'CLS0500300000100' or ER_Code = 'CLS0500300000101' or ER_Code = 'CLS0500300000102' or ER_Code = 'CLS0500300000103' or ER_Code = 'CLS0500300000104' or ER_Code = 'CLS0500300000105' or ER_Code = 'CLS0500300000106' or ER_Code = 'CLS0500300000107' or ER_Code = 'CLS0500500000236' or ER_Code = 'CLS0500500000237' or ER_Code = 'CLS0500500000238' or ER_Code = 'CLS0500500000239' or ER_Code = 'CLS0500300000108' or ER_Code = 'CLS0500300000109' or ER_Code = 'CLS0500300000110' or ER_Code = 'CLS0500300000111' or ER_Code = 'CLS0500300000112' or ER_Code = 'CLS0500300000113' or ER_Code = 'CLS0500300000115' or ER_Code = 'CLS0500300000116' or ER_Code = 'CLS0500300000117' or ER_Code = 'CLS0500300000118' or ER_Code = 'CLS0500300000119' or ER_Code = 'CLS0500300000120' or ER_Code = 'CLS0500300000121' or ER_Code = 'CLS0500500000240' or ER_Code = 'CLS0500500000241' or ER_Code = 'CLS0500500000242' or ER_Code = 'CLS0500300000031' or ER_Code = 'CLS0500300000032' or ER_Code = 'CLS0500300000033' or ER_Code = 'CLS0500300000034' or ER_Code = 'CLS0500300000035' or ER_Code = 'CLS0500300000042' or ER_Code = 'CLS0500300000043' or ER_Code = 'CLS0500500000156' or ER_Code = 'CLS0500500000157' or ER_Code = 'CLS0500500000158' or ER_Code = 'CLS0500500000209' or ER_Code = 'CLS0500500000211' or ER_Code = 'CLS0500500000212' or ER_Code = 'CLS0500500000213' or ER_Code = 'CLS0500300000008' or ER_Code = 'CLS0500300000009' or ER_Code = 'CLS0500300000010' or ER_Code = 'CLS0500500000148' or ER_Code = 'CLS0500500000149' or ER_Code = 'CLS0500500000150' or ER_Code = 'CLS0500300000260' or ER_Code = 'CLS0500300000259' or ER_Code = 'CLS0500300000258' or ER_Code = 'CLS0500300000257' or ER_Code = 'CLS0500300000256' or ER_Code = 'CLS0500300000255' or ER_Code = 'CLS0500300000253' or ER_Code = 'CLS0500300000336' or ER_Code = 'CLS0500300000334' or ER_Code = 'CLS0500300000333' or ER_Code = 'CLS0500300000331' or ER_Code = 'CLS0500300000329' or ER_Code = 'CLS0500300000328' or ER_Code = 'CLS0500500000729' or ER_Code = 'CLS0500500000728' or ER_Code = 'CLS0500300000150' or ER_Code = 'CLS0500300000151' or ER_Code = 'CLS0500500000719' or ER_Code = 'CLS0500500000285' or ER_Code = 'CLS0500500000286' or ER_Code = 'CLS0500500000287' or ER_Code = 'CLS0500500000288' or ER_Code = 'CLS0500000000895' or ER_Code = 'CLS0500300000190' or ER_Code = 'CLS0500300000191' or ER_Code = 'CLS0300100000031' or ER_Code = 'CLS0300100000032' or ER_Code = 'CLS0300100000061' or ER_Code = 'CLS0300100000062' or ER_Code = 'CLS0400000000079' or ER_Code = 'CLS0400000000080' or ER_Code = 'CLS0400000000081' or ER_Code = 'CLS0400000000082' or ER_Code = 'CLS0400000000083' or ER_Code = 'CLS0400000000084' or ER_Code = 'CLS0400000000085' or ER_Code = 'CLS0400000000086' or ER_Code = 'CLS0400000000087' or ER_Code = 'CLS0400000000136' or ER_Code = 'CLS0400000000137' or ER_Code = 'CLS0400000000138' or ER_Code = 'CLS0400000000393' or ER_Code = 'CLS0400000000394' or ER_Code = 'CLS0400000000395' or ER_Code = 'CLS0400000000396' or ER_Code = 'CLS0400000000397' or ER_Code = 'CLS0400000000472' or ER_Code = 'CLS0400000000473' or ER_Code = 'CLS0400000000474' or ER_Code = 'CLS0400000001331' or ER_Code = 'CLS0400000001332' or ER_Code = 'CLS0400000001333' or ER_Code = 'CLS0300000000114' or ER_Code = 'CLS0300000000115' or ER_Code = 'CLS0300000000116' or ER_Code = 'CLS0300000000117' or ER_Code = 'CLS0300000000118' or ER_Code = 'CLS0300000000119' or ER_Code = 'CLS0300000000128' or ER_Code = 'CLS0300000000129' or ER_Code = 'CLS0300000000130' or ER_Code = 'CLS0300000000131' or ER_Code = 'CLS0300000000132' or ER_Code = 'CLS0300000000133' or ER_Code = 'CLS0300000000134' or ER_Code = 'CLS0300000000135' or ER_Code = 'CLS0300000000136' or ER_Code = 'CLS0300000000005' or ER_Code = 'CLS0300000000006' or ER_Code = 'CLS0300100000208' or ER_Code = 'CLS0400000000001' or ER_Code = 'CLS0400000000002' or ER_Code = 'CLS0400000000003' or ER_Code = 'CLS0400000000004' or ER_Code = 'CLS0400000001274' or ER_Code = 'CLS0400000001275' or ER_Code = 'CLS0400000001276' or ER_Code = 'CLS0400000001277' or ER_Code = 'CLS0400000001278' or ER_Code = 'CLS0400000001279' or ER_Code = 'CLS0400000001280' or ER_Code = 'CLS0400000001281' or ER_Code = 'CLS0400000001282' or ER_Code = 'CLS0400000001283' or ER_Code = 'CLS0400000001284' or ER_Code = 'CLS0400000001285' or ER_Code = 'CLS0400000001334' or ER_Code = 'CLS0400000001335' or ER_Code = 'CLS0400000001336' or ER_Code = 'CLS0400000001337' or ER_Code = 'CLS0400000001338' or ER_Code = 'CLS0400000001341' or ER_Code = 'CLS0400000001342' or ER_Code = 'CLS0400000001343' or ER_Code = 'CLS0400000001344' or ER_Code = 'CLS0400000001345' or ER_Code = 'CLS0400000001346' or ER_Code = 'CLS0400000001347' or ER_Code = 'CLS0400000001348' or ER_Code = 'CLS0400000001349' or ER_Code = 'CLS0300000000166' or ER_Code = 'CLS0300000000167' or ER_Code = 'CLS0300000000168' or ER_Code = 'CLS0300000000169' or ER_Code = 'CLS0400000000157' or ER_Code = 'CLS0400000000158' or ER_Code = 'CLS0400000000159' or ER_Code = 'CLS0400000000160' or ER_Code = 'CLS0400000000161' or ER_Code = 'CLS0400000000162' or ER_Code = 'CLS0400000000169' or ER_Code = 'CLS0400000000170' or ER_Code = 'CLS0400000000414' or ER_Code = 'CLS0400000000415' or ER_Code = 'CLS0400000000416' or ER_Code = 'CLS0400000000425' or ER_Code = 'CLS0400000000426' or ER_Code = 'CLS0400000000427' or ER_Code = 'CLS0400000000428' or ER_Code = 'CLS0400000000429' or ER_Code = 'CLS0400000000430' or ER_Code = 'CLS0300100000152' or ER_Code = 'CLS0300100000153' or ER_Code = 'CLS0300100000154' or ER_Code = 'CLS0300100000171' or ER_Code = 'CLS0400000000059' or ER_Code = 'CLS0400000000060' or ER_Code = 'CLS0400000000061' or ER_Code = 'CLS0400000000076' or ER_Code = 'CLS0400000000077' or ER_Code = 'CLS0400000000078' or ER_Code = 'CLS0400000000098' or ER_Code = 'CLS0400000000099' or ER_Code = 'CLS0400000000100' or ER_Code = 'CLS0400000000101' or ER_Code = 'CLS0400000000102' or ER_Code = 'CLS0400000000103' or ER_Code = 'CLS0400000000104' or ER_Code = 'CLS0400000000105' or ER_Code = 'CLS0400000001308' or ER_Code = 'CLS0400000001309' or ER_Code = 'CLS0400000001310' or ER_Code = 'CLS0400000001311' or ER_Code = 'CLS0400000001326' or ER_Code = 'CLS0400000001327' or ER_Code = 'CLS0400000001328' or ER_Code = 'CLS0400000001329' or ER_Code = 'CLS0400000001330' or ER_Code = 'CLS0200000000053' or ER_Code = 'CLS0200000000071' or ER_Code = 'CLS0200000000348' or ER_Code = 'CLS0200000000955' or ER_Code = 'CLS0400000000975' or ER_Code = 'CLS0400000000976' or ER_Code = 'CLS0400000000977' or ER_Code = 'CLS0400000000978' or ER_Code = 'CLS0400000001181' or ER_Code = 'CLS0400000001182' or ER_Code = 'CLS0400000001216' or ER_Code = 'CLS0400000001217' or ER_Code = 'CLS0400000001218' or ER_Code = 'CLS0400000001219' or ER_Code = 'CLS0400000001220' or ER_Code = 'CLS0400000001221' or ER_Code = 'CLS0400000001222' or ER_Code = 'CLS0400000001223' or ER_Code = 'CLS0400000001224' or ER_Code = 'CLS0400000001225' or ER_Code = 'CLS0400000001226' or ER_Code = 'CLS0400000001227' or ER_Code = 'CLS0400000001251' or ER_Code = 'CLS0400000001252' or ER_Code = 'CLS0400000001253' or ER_Code = 'CLS0400000001254' or ER_Code = 'CLS0400000001255' or ER_Code = 'CLS0400000001387' or ER_Code = 'CLS0400000001388' or ER_Code = 'CLS0400000001396' or ER_Code = 'CLS0400000001397' or ER_Code = 'CLS0400000001398' or ER_Code = 'CLS0200000005962' or ER_Code = 'CLS0200000005963' or ER_Code = 'CLS0200000006018' or ER_Code = 'CLS0200000006019' or ER_Code = 'CLS0200000006020' or ER_Code = 'CLS0200000006021' or ER_Code = 'CLS0200000006303' or ER_Code = 'CLS0200000006783' or ER_Code = 'CLS0200000001898' or ER_Code = 'CLS0400000001203' or ER_Code = 'CLS0400000001204' or ER_Code = 'CLS0400000001205' or ER_Code = 'CLS0400000001206' or ER_Code = 'CLS0400000001207' or ER_Code = 'CLS0400000001251' or ER_Code = 'CLS0400000001252' or ER_Code = 'CLS0400000001253' or ER_Code = 'CLS0400000001254' or ER_Code = 'CLS0400000001255' or ER_Code = 'CLS0200000000062' or ER_Code = 'CLS0200000001908' or ER_Code = 'CLS0200000004665' or ER_Code = 'CLS0400000001112' or ER_Code = 'CLS0400000001113' or ER_Code = 'CLS0400000001114' or ER_Code = 'CLS0400000001115' or ER_Code = 'CLS0400000001135' or ER_Code = 'CLS0400000001136' or ER_Code = 'CLS0400000001149' or ER_Code = 'CLS0400000001150' or ER_Code = 'CLS0400000001151' or ER_Code = 'CLS0400000001152' or ER_Code = 'CLS0400000001164' or ER_Code = 'CLS0400000001165' or ER_Code = 'CLS0400000001166' or ER_Code = 'CLS0400000001167' or ER_Code = 'CLS0400000001168' or ER_Code = 'CLS0400000001169' or ER_Code = 'CLS0400000001170' or ER_Code = 'CLS0400000001171' or ER_Code = 'CLS0200000000465' or ER_Code = 'CLS0200000001190' or ER_Code = 'CLS0200000005120' or ER_Code = 'CLS0200000005121' or ER_Code = 'CLS0200000006881' or ER_Code = 'CLS0400000000673' or ER_Code = 'CLS0400000000674' or ER_Code = 'CLS0400000000675' or ER_Code = 'CLS0400000001057' or ER_Code = 'CLS0400000001058' or ER_Code = 'CLS0400000001059' or ER_Code = 'CLS0400000001060' or ER_Code = 'CLS0400000001061' or ER_Code = 'CLS0400000001062' or ER_Code = 'CLS0400000001120' or ER_Code = 'CLS0400000001121' or ER_Code = 'CLS0400000001122' or ER_Code = 'CLS0400000001123' or ER_Code = 'CLS0200000000993' or ER_Code = 'CLS0200000003515' or ER_Code = 'CLS0200000003771' or ER_Code = 'CLS0200000004865' or ER_Code = 'CLS0200000005045' or ER_Code = 'CLS0200000005046' or ER_Code = 'CLS0200000005339' or ER_Code = 'CLS0200000005340' or ER_Code = 'CLS0200000005715' or ER_Code = 'CLS0200000005716' or ER_Code = 'CLS0200000005816' or ER_Code = 'CLS0200000000683' or ER_Code = 'CLS0200000001186' or ER_Code = 'CLS0200000002214' or ER_Code = 'CLS0200000002215' or ER_Code = 'CLS0200000002216' or ER_Code = 'CLS0200000002217' or ER_Code = 'CLS0200000005216' or ER_Code = 'CLS0200000005217' or ER_Code = 'CLS0200000007171' or ER_Code = 'CLS0200000007172' or ER_Code = 'CLS0400000000752' or ER_Code = 'CLS0400000000753' or ER_Code = 'CLS0400000000754' or ER_Code = 'CLS0400000000755' or ER_Code = 'CLS0500000000303' or ER_Code = 'CLS0500100000007' or ER_Code = 'CLS0500500000301' or ER_Code = 'CLS0500500000302' or ER_Code = 'CLS0500500000304' or ER_Code = 'CLS0500500000306' or ER_Code = 'CLS0500500000307' or ER_Code = 'CLS0500500000354' or ER_Code = 'CLS0500600000396' or ER_Code = 'CLS0500600000397' or ER_Code = 'CLS0500600000398' or ER_Code = 'CLS0500600000399' or ER_Code = 'CLS0500600000400' or ER_Code = 'CLS0500600000401' or ER_Code = 'CLS0500600000402' or ER_Code = 'CLS0500600000403' or ER_Code = 'CLS0500600000404' or ER_Code = 'CLS0500600000560' or ER_Code = 'CLS0500600000559' or ER_Code = 'CLS0500600000558' or ER_Code = 'CLS0500600000557' or ER_Code = 'CLS0500600000545' or ER_Code = 'CLS0500100000334' or ER_Code = 'CLS0500100000330' or ER_Code = 'CLS0500600000493' or ER_Code = 'CLS0500600000488' or ER_Code = 'CLS0500600000485' or ER_Code = 'CLS0500000000797' or ER_Code = 'CLS0500000000792' or ER_Code = 'CLS0500000000790' or ER_Code = 'CLS0500000001083' or ER_Code = 'CLS0500000001071' or ER_Code = 'CLS0500000001040' or ER_Code = 'CLS0500000000290' or ER_Code = 'CLS0500200000066' or ER_Code = 'CLS0500200000067' or ER_Code = 'CLS0500200000078' or ER_Code = 'CLS0500200000079' or ER_Code = 'CLS0500300000047' or ER_Code = 'CLS0500300000048' or ER_Code = 'CLS0500500000174' or ER_Code = 'CLS0500500000175' or ER_Code = 'CLS0500500000176' or ER_Code = 'CLS0500500000566' or ER_Code = 'CLS0500500000567' or ER_Code = 'CLS0500500000568' or ER_Code = 'CLS0500500000594' or ER_Code = 'CLS0500500000593' or ER_Code = 'CLS0500200000030' or ER_Code = 'CLS0500200000031' or ER_Code = 'CLS0500200000032' or ER_Code = 'CLS0500200000033' or ER_Code = 'CLS0500200000034' or ER_Code = 'CLS0500200000036' or ER_Code = 'CLS0500500000593' or ER_Code = 'CLS0500500000594' or ER_Code = 'CLS0500200000100' or ER_Code = 'CLS0500200000101' or ER_Code = 'CLS0500200000102' or ER_Code = 'CLS0500200000103' or ER_Code = 'CLS0500200000104' or ER_Code = 'CLS0500200000105' or ER_Code = 'CLS0500200000106' or ER_Code = 'CLS0500500000627'");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erUpload = map.get("ER_Upload");
			erThumbnail = map.get("ER_Thumbnail");
			erInThum = map.get("ER_InThum");
			erAudio = map.get("ER_Audio");
			if(erAudio!=null && !"".equals(erAudio)){
				CopyData.copyFile(srcUpload+"\\"+erAudio,toUpload+"\\"+erAudio);
			}
			CopyData.copyFile(srcUpload+"\\"+erUpload,toUpload+"\\"+erUpload);
			CopyData.copyFile(srcUpload+"\\"+erThumbnail,toUpload+"\\"+erThumbnail);
			CopyData.copyFile(srcUpload+"\\"+erInThum,toUpload+"\\"+erInThum);
			System.out.println(index);
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleObse(String srcUpload,String toUpload){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erThumbnail = "",erInThum = "",erUpload = "",erType = "",erFileSwf = "",erZip = ""; 
		long index = 0l;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM `res_observation_room` where OR_NO = 'GCS0000200000006' or OR_NO = 'GCS0000100000069' or OR_NO = 'GCS0000100000064'");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erType = map.get("OR_Type");
			erUpload = map.get("OR_Upload");
			erThumbnail = map.get("OR_Thumbnail");
			erInThum = map.get("OR_InThum");
			if(erType.equals("1084")){
				erFileSwf = map.get("OR_FileSwf");
				CopyData.copyFile(srcUpload+"\\"+erFileSwf,toUpload+"\\"+erFileSwf);
			}
			if(erType.equals("4033")){
				erFileSwf = map.get("OR_FileSwf");
				erZip = map.get("OR_Zip");
				String format[] = erZip.split(",");
				for(int i = 0;i<Integer.parseInt(format[2]);i++){//3d_image (0)
					CopyData.copyFile(srcUpload+"\\"+erFileSwf+"\\"+format[0]+"("+i+")"+format[1],toUpload+"\\"+erFileSwf+"\\"+format[0]+"("+i+")"+format[1]);	
				}
			}
			CopyData.copyFile(srcUpload+"\\"+erUpload,toUpload+"\\"+erUpload);
			String mat = "images/resImage";
			if(erThumbnail.indexOf(mat)<0){
				CopyData.copyFile(srcUpload+"\\"+erThumbnail,toUpload+"\\"+erThumbnail);
				//CopyData.copyFile(srcUpload+"\\"+erInThum,toUpload+"\\"+erInThum);
			}
			System.out.println(index);
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleLabo(String srcUpload,String toUpload){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erThumbnail = "",erInThum = "",erUpload = "",erType = "",erFileSwf = "",erFileSwfPath = ""; 
		long index = 0l;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM `res_laboratory_room` where LR_NO = 'SYS0000000000003' or LR_NO = 'SYS0000000000009' or LR_NO = 'SYS0000000000007'");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erType = map.get("LR_Type");
			erUpload = map.get("LR_Upload");
			erThumbnail = map.get("LR_Thumbnail");
			erInThum = map.get("LR_InThum");
			
			
			if(erType.equals("1084")){
				erFileSwf = map.get("LR_FileSwf");
				CopyData.copyFile(srcUpload+"\\"+erFileSwf,toUpload+"\\"+erFileSwf);
				CopyData.copyFile(srcUpload+"\\"+erUpload.replace("WMV", "mp4").replace("wmv", "mp4"),toUpload+"\\"+erUpload.replace("WMV", "mp4").replace("wmv", "mp4"));
			}
			
			String mat1 = "2041 2055 2033";
			if(mat1.indexOf(erType)>-1){
				erFileSwf = map.get("LR_FileSwf");
				erFileSwfPath = map.get("LR_FileSwfPath");
				CopyData.copyFile(srcUpload+"\\"+erFileSwfPath,toUpload+"\\"+erFileSwfPath);
				
				File count=new File(srcUpload+"\\"+erFileSwf);
				int h = count.listFiles().length;
				for(int i = 1;i<=h;i++){
					if(new File(srcUpload+"\\"+erFileSwf+"\\"+i+".jpg").exists()){
						CopyData.copyFile(srcUpload+"\\"+erFileSwf+"\\"+i+".jpg",toUpload+"\\"+erFileSwf+"\\"+i+".jpg");
					}
				}
				//CopyData.copyFile(srcUpload+"\\"+erFileSwf,toUpload+"\\"+erFileSwf);
			}
			
			CopyData.copyFile(srcUpload+"\\"+erUpload,toUpload+"\\"+erUpload);
			
			String mat2 = "images/resImage";
			if(erThumbnail.indexOf(mat2)<0 && erInThum.indexOf(mat2) <0){
				CopyData.copyFile(srcUpload+"\\"+erThumbnail,toUpload+"\\"+erThumbnail);
				CopyData.copyFile(srcUpload+"\\"+erInThum,toUpload+"\\"+erInThum);
			}
			System.out.println(index);
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleProj(String srcUpload,String toUpload){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erThumbnail = "",erInThum = "",erUpload = "",erType = "",erFileSwf = ""; 
		long index = 0l;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM `res_projection_room` where PR_No = 'FYS0000200000121' or PR_No = 'FYS0000100000003' or PR_No = 'FYS0000000000119' or PR_No = 'FYS0000400000006' or PR_No = 'FYS0000300000058' or PR_No = 'FYS0000300000048' or PR_No = 'FYS0000500000002' or PR_No = 'FYS0000300000066'");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erType = map.get("PR_Type");
			erUpload = map.get("PR_Upload");
			erThumbnail = map.get("PR_Thumbnail");
			erInThum = map.get("PR_InThum");
			if(erType.equals("1084")){
				erFileSwf = map.get("PR_FileSwf");
				CopyData.copyFile(srcUpload+"\\"+erFileSwf,toUpload+"\\"+erFileSwf);
				CopyData.copyFile(srcUpload+"\\"+erUpload.replace("WMV", "mp4").replace("wmv", "mp4"),toUpload+"\\"+erUpload.replace("WMV", "mp4").replace("wmv", "mp4"));
			}
			CopyData.copyFile(srcUpload+"\\"+erUpload,toUpload+"\\"+erUpload);
			String mat2 = "images/resImage";
			if(erThumbnail.indexOf(mat2)<0){
				CopyData.copyFile(srcUpload+"\\"+erThumbnail,toUpload+"\\"+erThumbnail);
				//CopyData.copyFile(srcUpload+"\\"+erInThum,toUpload+"\\"+erInThum);
			}
			System.out.println(index);
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleExpa(String srcUpload,String toUpload){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erThumbnail = "",erInThum = "",erUpload = "",erFileSwfPath = ""; 
		long index = 0l;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM `res_expand_room` where   ER_No = 'TZS0000000000002' or ER_No = 'TZS0000100000010'");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erUpload = map.get("ER_Upload");
			erThumbnail = map.get("ER_Thumbnail");
			erInThum = map.get("ER_InThum");
			/*erFileSwfPath = map.get("ER_FileSwfPath");*/
			
			CopyData.copyFile(srcUpload+"\\"+erUpload,toUpload+"\\"+erUpload);
			
			/*CopyData.copyFile(srcUpload+"\\"+erFileSwfPath,toUpload+"\\"+erFileSwfPath);*/
			String mat2 = "images/resImage";
			if(erThumbnail.indexOf(mat2)<0){
				CopyData.copyFile(srcUpload+"\\"+erThumbnail,toUpload+"\\"+erThumbnail);
				//CopyData.copyFile(srcUpload+"\\"+erInThum,toUpload+"\\"+erInThum);
			}
			System.out.println(index);
		}
	}
}