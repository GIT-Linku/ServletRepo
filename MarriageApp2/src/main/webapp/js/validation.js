    function validate(frm){
	//empty the form validation error message
	document.getElementById("cnameErr").innerHTML="";
	document.getElementById("cageErr").innerHTML="";
	document.getElementById("cgenderErr").innerHTML="";
	
	//read data from form
	let name=frm.cname.value;
	let age=frm.cage.value;
	let gender=frm.cgender.value;
	
	//client side form validation
	let flag = true;
	if(name==""){  //required rule on person name
		document.getElementById("cnameErr").innerHTML="Person name is required";
		frm.cname.focus();
		flag=false;
	}
	if(age==""){  //required rule in person address
		document.getElementById("cageErr").innerHTML="Person age is required";
		frm.cage.focus();
		flag=false;
	}
	else if(isNaN(age)){  //must be numeric value
		document.getElementById("cageErr").innerHTML="Person age must be numeric value";
	    frm.cage.focus();
	    flag=false;
	}
	else if(age<=0 || age>125){  //range rule on age
		document.getElementById("cageErr").innerHTML="Person age must be there between 1-125";
		frm.cage.focus();
		flag=false;
	}
	if(gender==""){  //required rule in person age
		document.getElementById("cgenderErr").innerHTML="Person gender is required";
		frm.cgender.focus();
		flag=false;
	}
	//change hidden box value (vflag) to yes indicating client side form validation are done
	frm.vflag.value="yes";
	return flag;
  }//function