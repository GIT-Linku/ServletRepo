    function validate(frm){
	//empty the form validation error message
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("paddrsErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	//read data from form
	let name=frm.pname.value;
	let addrs=frm.paddrs.value;
	let age=frm.page.value;
	
	//client side form validation
	let flag = true;
	if(name==""){  //required rule on person name
		document.getElementById("pnameErr").innerHTML="Person name is required";
		frm.pname.focus();
		flag=false;
	}
	if(addrs==""){  //required rule in person address
		document.getElementById("paddrsErr").innerHTML="Person address is required";
		frm.paddrs.focus();
		flag=false;
	}
	else if(addrs.length<10){  //minlength rule on person address
		document.getElementById("paddrsErr").innerHTML="Person address must have minimum 10 charecter";
	    frm.paddrs.focus();
	    flag=false;
	}
	if(age==""){  //required rule in person age
		document.getElementById("pageErr").innerHTML="Person age is required";
		frm.page.focus();
		flag=false;
	}
	else if(isNaN(age)){  //must be numeric value
		document.getElementById("pageErr").innerHTML="Person age must be numeric value";
	    frm.page.focus();
	    flag=false;
	}
	else if(age<=0 || age>125){  //range rule on age
		document.getElementById("pageErr").innerHTML="Persom age must be there between 1-125";
		frm.page.focus();
		flag=false;
	}
	return flag;
  }//function