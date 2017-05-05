
function pageInit(){
	makeYear();
	makeMonth();
	makeDay();
}

function check(){
	connectBirthday();
	return true;
}


function makeYear(){
	
	var year = document.getElementById("year");
	
	for(var i=1981;i<=2016;i++){
		var option = document.createElement("option");
		option.value = i;							//值
		option.innerText = i;						//中间夹的数据
		year.appendChild(option);
	}
	
}


function makeMonth(){
	var month = document.getElementById("month");
	
	for(var i=2;i<=12;i++){
		var option = document.createElement("option");
		if(i<10){
			option.value = '0'+i;
			option.innerText ='0'+i;
		}else{
			option.value=i;
			option.innerText = i;
		}
		month.appendChild(option);
	}
	
}


function makeDay(){
	var day = document.getElementById("day");
	
	for(var i=2;i<=30;i++){
		var option = document.createElement("option");
		if(i<10){
			option.value = '0'+i;
			option.innerText ='0'+i;
		}else{
			option.value=i;
			option.innerText = i;
		}
		day.appendChild(option);
	}
}


function connectBirthday(){
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;

	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "birthday";										//名字为birthday
	input.value = year + '-' + month + '-' +day;
	
	document.getElementById("student").appendChild(input);
}
