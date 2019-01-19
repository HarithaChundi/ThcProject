var token='eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MzM1NDc4Mzk3NDF9.JCSXKM2swRKUVlmRTesx5zGvT-HRqG8DWxXenVCvZRE';
headers= {'x-access-token':token,'Content-Type':'application/json','x-key':'haritha'};

function getFunction(){

	$.ajax({
		type:"GET",
		headers:headers,
		url:"http://localhost:8080/api/v1/vitals",
		data:""
	})
	.done(function (response) {
		var data =JSON.stringify(response)
		alert(data)
		var id = response.vitalId;
		alert(id)
	})
	.fail(function (jqXHR, exception) {
		error(jqXHR, exception);
	})//error end
	.always(function () {
		alert("complete");
	});
}//getFunction()


function myfunction(){
	alert("post")
	//var id=$("#id")
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
var present;

function edit(){
//	alert("edit")
	var id=14;
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
				url:"http://localhost:8080/api/v1/vitals/"+id,
				data:""
			})

			.done(function (response) {
			//	alert(66)
				present =JSON.stringify(response)

				//	 alert(present)
				display();
				//  $("#id").val(response.vitalId);
				$("#weight1").val(response.weight);
				$("#weight_unit1").val(response.weightUnit);
				$("#height1").val(response.height1);
				$("#height1_unit1").val(response.height1Unit);
				$("#height21").val(response.height2);
				$("#height2_unit1").val(response.height2Unit);
				$("#bmi1").val(response.bmi);
				$("#bp_systolic1").val(response.bpSystolic);
				$("#bp_diastolic1").val(response.bpDiastolic);
				$("#temperature1").val(response.temperature);
				$("#pulse_rate1").val(response.pulseRate);
				$("#pulse_pattern1").val(response.pulsePattern);
				$("#pulse_volume1").val(response.pulseVolume);
				$("#notes1").val(response.additionalNotes);    	     			            

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
	var id=14;
//	var id=$("#id");
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
		var postData=JSON.stringify({"medicalRecordNo":MRNO,"episodeId":EID,"visitId":VID,"weight":Weight,"weightUnit":weight_unit,"height1":height,"height1Unit":h1_unit,"height2":h2,"height2Unit":h2_unit,"bmi":bmi,"bpSystolic":BP_Systolic,"bpDiastolic":BP_Diastolic,"temperature":Temperature,"pulseRate":Pulse_Rate,"pulsePattern":Pulse_Pattern,"pulseVolume":Pulse_Volume,"additionalNotes":Additional_Notes,"updated_by":updated,"vitalId":id});
	alert(postData);
	$.ajax({
		url:"http://localhost:8080/api/v1/vitals/update",
		type:"PUT",
		data: postData , 
		contentType: "application/json" ,	
		dataType: "text",
		headers:headers,
		processdata: true })
		.done(function (data) {
			alert(data)
			location.assign("vitals-master.html");
		})
		.fail(function (jqXHR, exception) {
			error(jqXHR, exception);
		})
		.always(function () {
			alert("complete");
		});
}

function display(){
	if (present=="[]") {
		$("#Submitfunction").show();
		$("#Updatefunction").hide();		
	}
	else {
		$("#Updatefunction").show();
		$("#Submitfunction").hide();		
	}
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
