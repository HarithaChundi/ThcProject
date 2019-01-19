var token='eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MzM4MTYwMjU3MTB9.6By5rUT4K5GlLXV5zBPFn8vEItW6Q1ABB2PSrLaz4PI';
headers= {'x-access-token':token,'Content-Type':'application/json','x-key':'haritha'};

$(document).ready(
		function() {
			edit();
			sessionStorage.setItem("MRNO", "1001");
			sessionStorage.setItem("EID", "01");
			sessionStorage.setItem("VID", "01");
			$("#bmi1").blur(
					function() {
						var Weight = Number($("#weight1").val());
						var height = Number($("#height1").val());
						var inch = Number(($("#height21").val()));
						if ((Weight == "" && height == "")
								|| (Weight == "" || height == "")) {
							$("#bmi1").val(0);
						} else {
							var height1 = ((height) * 12) + inch;
							var height2 = Math.pow(height1, 2);
							var bmi = (Weight) / height2;
							var bmi1 = bmi.toFixed(3);
							$("#bmi1").val(bmi1);
						}
					});

			$("#bmi1").blur(
					function() {
						var Weight = Number($("#weight1").val());
						var height = Number($("#height1").val());
						var inch = Number(($("#height21").val()));
						if ((Weight == "" && height == "")
								|| (Weight == "" || height == "")) {
							$("#bmi1").val(0);
						} else {

							var height1 = ((height) * 12) + inch;
							var height2 = Math.pow(height1, 2);
							var bmi = (Weight) / height2;
							var bmi1 = bmi.toFixed(3);
							$("#bmi1").val(bmi1);
						}
					});
		});

function myfunction(){
	var Weight=$("#weight1").val();
	var weight_unit=$("#weight_unit1").val();
	var height=Number($("#height1").val());
	var h1_unit=$("#height1_unit1").val();
	var h2=Number($("#height21").val());
	var h2_unit=$("#height2_unit1").val();	
	var bmi=$("#bmi1").val();
	var BP_Systolic=$("#bp_systolic1").val();
	var BP_Diastolic=$("#bp_diastolic1").val();
	var Temperature=$("#temperature1").val();
	var Pulse_Rate=$("#pulse_rate1").val();
	var Pulse_Pattern=$("#pulse_pattern1").val();
	var Pulse_Volume=$("#pulse_volume1").val();
	var Additional_Notes=$("#notes1").val();		
	var created="haritha";	
	var MRNO=sessionStorage.getItem("MRNO");
	var EID=sessionStorage.getItem("EID");
	var VID=sessionStorage.getItem("VID");
	var postData=JSON.stringify({"medicalRecordNo":MRNO,"episodeId":EID,"visitId":VID,"weight":Weight,"weightUnit":weight_unit,"height1":height,"height1Unit":h1_unit,"height2":h2,"height2Unit":h2_unit,"bmi":bmi,"bpSystolic":BP_Systolic,"bpDiastolic":BP_Diastolic,"temperature":Temperature,"pulseRate":Pulse_Rate,"pulsePattern":Pulse_Pattern,"pulseVolume":Pulse_Volume,"additionalNotes":Additional_Notes,"created_by":created});
	alert(pastData)
	$.ajax({		
		url:"http://localhost:8080/api/v1/vitals/",
		type:"POST",
		data: postData , 		
		contentType: "application/json" ,	
		dataType: "text" ,
		headers:headers,
		processdata: true })
		.done(function (data) {
			//alert("success");			
		})
		.fail(function (jqXHR, exception) {
			error(jqXHR, exception);
		})//error end
		.always(function () {
			alert("complete");
		});
}

function edit(){
	var id=1;
	sessionStorage.setItem("MRNO","1001");
	sessionStorage.setItem("EID","01");
	sessionStorage.setItem("VID","01");
	var MRNO=sessionStorage.getItem("MRNO");
	var EID=sessionStorage.getItem("EID");
	var VID=sessionStorage.getItem("VID");	
	$(function(){ 
		if(!(id==null)){  
			$.ajax({
				type:"GET",
				headers:headers,
				url:"http://127.0.0.1:3000/api/v1/vitals/"+id,
				data:""
			})
			.done(function (data) {
				var data=JSON.parse(data);
				$.each(data,function(key,obj){	         	   
					$("#weight1").val(obj.weight);
					$("#weight_unit1").val(obj.weight_unit);
					$("#height1").val(obj.height1);
					$("#height1_unit1").val(obj.height1_unit);
					$("#height21").val(obj.height2);
					$("#height2_unit1").val(obj.height2_unit);
					$("#bmi1").val(obj.bmi);
					$("#bp_systolic1").val(obj.bp_systolic);
					$("#bp_diastolic1").val(obj.bp_diastolic);
					$("#temperature1").val(obj.temperature);
					$("#pulse_rate1").val(obj.pulse_rate);
					$("#pulse_pattern1").val(obj.pulse_pattern);
					$("#pulse_volume1").val(obj.pulse_volume);
					$("#notes1").val(obj.additional_notes);    	     			            
				});
			})
			.fail(function (jqXHR, exception) {
				error(jqXHR, exception);
			})//error end
			.always(function () {
				alert("complete");
			});
		}
	});	
}

function Update(){
	var MRNO=sessionStorage.getItem("MRNO");
	var EID=sessionStorage.getItem("EID");
	var VID=sessionStorage.getItem("VID");
	var id=1;
	var Weight=$("#weight1").val();	
	var weight_unit=$("#weight_unit1").val();
	var height=Number($("#height1").val());
	var h1_unit=$("#height1_unit1").val();
	var h2=Number($("#height21").val());
	var h2_unit=$("#height2_unit1").val();	
	var bmi=$("#bmi1").val();
	var BP_Systolic=$("#bp_systolic1").val();	
	var BP_Diastolic=$("#bp_diastolic1").val();	
	var Temperature=$("#temperature1").val();	
	var Pulse_Rate=$("#pulse_rate1").val();	
	var Pulse_Pattern=$("#pulse_pattern1").val();
	var Pulse_Volume=$("#pulse_volume1").val();	
	var Additional_Notes=$("#notes1").val(); 
	var updated="haritha"	
		var postData=JSON.stringify({"medical_record_no":MRNO,"episode_id":EID,"visit_id":VID,"weight":Weight,"weight_unit":weight_unit,"height1":height,"height1_unit":h1_unit,"height2":h2,"height2_unit":h2_unit,"bmi":bmi,"bp_systolic":BP_Systolic,"bp_diastolic":BP_Diastolic,"temperature":Temperature,"pulse_rate":Pulse_Rate,"pulse_pattern":Pulse_Pattern,"pulse_volume":Pulse_Volume,"additional_notes":Additional_Notes,"updated_by":updated,"id":id});
	$.ajax({
		url:"http://127.0.0.1:3000/api/v1/vitals/update",
		type:"PUT",
		data: postData , 
		contentType: "application/json" ,	
		dataType: "text",
		headers:headers,
		processdata: true })
		.done(function (data) {
			location.assign("vitals-master.html");
		})
		.fail(function (jqXHR, exception) {
			error(jqXHR, exception);
		})
		.always(function () {
			alert("complete");
		});
}

function error(jqXHR, exception) {
	var msg = '';
	if (jqXHR.status === 0) {
		msg = 'Not connect.\n Verify Network.';
	} else if (jqXHR.status == 404) {
		msg = 'Requested page not found. [404]';
	} else if (jqXHR.status == 500) {
		msg = 'Internal Server Error [500].';
	} else if (exception === 'parsererror') {
		msg = 'Requested JSON parse failed.';
	} else if (exception === 'timeout') {
		msg = 'Time out error.';
	} else if (exception === 'abort') {
		msg = 'Ajax request aborted.';
	} else {
		msg = 'Uncaught Error.\n' + jqXHR.responseText;
	}
	alert(msg);
}
