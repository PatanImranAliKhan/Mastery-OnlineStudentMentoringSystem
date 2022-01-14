function CheckName()
{
    var name=document.getElementById('mname').value;
    const len=name.length;
    if(len==0)
    {
        document.getElementById('mname').style.borderColor="red";
        document.getElementById('err1_m').innerText="This field is required";
        document.getElementById('suc_1_m').style.visibility="hidden";
        document.getElementById('fail_1_m').style.visibility="visible";
    }
    else if(len <3)
    {
        document.getElementById('mname').style.borderColor="red";
        document.getElementById('err1_m').innerText="text must be atleast 3 digits";
        document.getElementById('suc_1_m').style.visibility="hidden";
        document.getElementById('fail_1_m').style.visibility="visible";
    }
    else
    {
        document.getElementById('mname').style.borderColor="green";
        document.getElementById('err1_m').innerText="";
        document.getElementById('fail_1_m').style.visibility="hidden";
        document.getElementById('suc_1_m').style.visibility="visible";
    }
}

function CheckParentName()
{
    var name=document.getElementById('pname').value;
    const len=name.length;
    if(len==0)
    {
        document.getElementById('pname').style.borderColor="red";
        document.getElementById('err5').innerText="This field is required";
        document.getElementById('suc_5').style.visibility="hidden";
        document.getElementById('fail_5').style.visibility="visible";
    }
    else if(len <3)
    {
        document.getElementById('pname').style.borderColor="red";
        document.getElementById('err5').innerText="text must be atleast 3 digits";
        document.getElementById('suc_5').style.visibility="hidden";
        document.getElementById('fail_5').style.visibility="visible";
    }
    else
    {
        document.getElementById('pname').style.borderColor="green";
        document.getElementById('err5').innerText="";
        document.getElementById('fail_5').style.visibility="hidden";
        document.getElementById('suc_5').style.visibility="visible";
    }
}

function CheckFirstName()
{
    var name=document.getElementById('fname').value;
    const len=name.length;
    if(len==0)
    {
        document.getElementById('fname').style.borderColor="red";
        document.getElementById('err1').innerText="This field is required";
        document.getElementById('suc_1').style.visibility="hidden";
        document.getElementById('fail_1').style.visibility="visible";
    }
    else if(len <3)
    {
        document.getElementById('fname').style.borderColor="red";
        document.getElementById('err1').innerText="firstname must be atleast 3 digits";
        document.getElementById('suc_1').style.visibility="hidden";
        document.getElementById('fail_1').style.visibility="visible";
    }
    else
    {
        document.getElementById('fname').style.borderColor="green";
        document.getElementById('err1').innerText="";
        document.getElementById('fail_1').style.visibility="hidden";
        document.getElementById('suc_1').style.visibility="visible";
    }
}

function CheckLastName()
{
    var name=document.getElementById('lname').value;
    const len=name.length;
    if(len==0)
    {
        document.getElementById('lname').style.borderColor="red";
        document.getElementById('err2').innerText="This field is required";
        document.getElementById('suc_2').style.visibility="hidden";
        document.getElementById('fail_2').style.visibility="visible";
    }
    else if(len <2)
    {
        document.getElementById('lname').style.borderColor="red";
        document.getElementById('err2').innerText="Lasname must be atleast 2 digits";
        document.getElementById('suc_2').style.visibility="hidden";
        document.getElementById('fail_2').style.visibility="visible";
    }
    else
    {
        document.getElementById('lname').style.borderColor="green";
        document.getElementById('err2').innerText="";
        document.getElementById('fail_2').style.visibility="hidden";
        document.getElementById('suc_2').style.visibility="visible";
    }
}

function CheckEmail()
{
    const email=document.getElementById('email').value;
    if(email=='')
    {
        document.getElementById('email').style.borderColor="red";
        document.getElementById('err3').innerText="This field is required";
        document.getElementById('suc_3').style.visibility="hidden";
        document.getElementById('fail_3').style.visibility="visible";
    }
    else if(!isEmail(email))
    {
        document.getElementById('email').style.borderColor="red";
        document.getElementById('err3').innerText="must be an email";
        document.getElementById('suc_3').style.visibility="hidden";
        document.getElementById('fail_3').style.visibility="visible";
    }
    else
    {
        document.getElementById('email').style.borderColor="green";
        document.getElementById('err3').innerText="";
        document.getElementById('fail_3').style.visibility="hidden";
        document.getElementById('suc_3').style.visibility="visible";
    }
}

function CheckEmailPar()
{
    const email=document.getElementById('pemail').value;
    if(email=='')
    {
        document.getElementById('pemail').style.borderColor="red";
        document.getElementById('err6').innerText="This field is required";
        document.getElementById('suc_6').style.visibility="hidden";
        document.getElementById('fail_6').style.visibility="visible";
    }
    else if(!isEmail(email))
    {
        document.getElementById('pemail').style.borderColor="red";
        document.getElementById('err6').innerText="must be an email";
        document.getElementById('suc_6').style.visibility="hidden";
        document.getElementById('fail_6').style.visibility="visible";
    }
    else
    {
        document.getElementById('pemail').style.borderColor="green";
        document.getElementById('err6').innerText="";
        document.getElementById('fail_6').style.visibility="hidden";
        document.getElementById('suc_6').style.visibility="visible";
    }
}

function isEmail(email) {
	return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function CheckMobile()
{
    const data=document.getElementById('mobile').value;
    const abc=data.toString().length;
    if(abc==0)
    {
        document.getElementById('mobile').style.borderColor="red";
        document.getElementById('err4').innerText="This field is required";
        document.getElementById('suc_4').style.visibility="hidden";
        document.getElementById('fail_4').style.visibility="visible";
    }
    else if(abc==10)
    {
        document.getElementById('mobile').style.borderColor="green";
        document.getElementById('err4').innerText="";
        document.getElementById('fail_4').style.visibility="hidden";
        document.getElementById('suc_4').style.visibility="visible";
    }
    else
    {
        document.getElementById('mobile').style.borderColor="red";
        document.getElementById('err4').innerText="must be contain 10 digits";
        document.getElementById('suc_4').style.visibility="hidden";
        document.getElementById('fail_4').style.visibility="visible";
    }
}

function CheckMobilePar()
{
    const data=document.getElementById('pmobile').value;
    const abc=data.toString().length;
    if(abc==0)
    {
        document.getElementById('pmobile').style.borderColor="red";
        document.getElementById('err7').innerText="This field is required";
        document.getElementById('suc_7').style.visibility="hidden";
        document.getElementById('fail_7').style.visibility="visible";
    }
    else if(abc==10)
    {
        document.getElementById('pmobile').style.borderColor="green";
        document.getElementById('err7').innerText="";
        document.getElementById('fail_7').style.visibility="hidden";
        document.getElementById('suc_7').style.visibility="visible";
    }
    else
    {
        document.getElementById('pmobile').style.borderColor="red";
        document.getElementById('err7').innerText="must be contain 10 digits";
        document.getElementById('suc_7').style.visibility="hidden";
        document.getElementById('fail_7').style.visibility="visible";
    }
}

function CheckIdMentor()
{
    const data=document.getElementById('mid').value;
    const abc=data.toString().length;
    if(abc==0)
    {
        document.getElementById('mid').style.borderColor="red";
        document.getElementById('err2').innerText="This field is required";
        document.getElementById('suc_2').style.visibility="hidden";
        document.getElementById('fail_2').style.visibility="visible";
    }
    else if(abc==4)
    {
        document.getElementById('mid').style.borderColor="green";
        document.getElementById('err2').innerText="";
        document.getElementById('fail_2').style.visibility="hidden";
        document.getElementById('suc_2').style.visibility="visible";
    }
    else
    {
        document.getElementById('mid').style.borderColor="red";
        document.getElementById('err2').innerText="must be contain 4 digits";
        document.getElementById('suc_2').style.visibility="hidden";
        document.getElementById('fail_2').style.visibility="visible";
    }
}

function CheckIdStd()
{
    const data=document.getElementById('sid').value;
    const abc=data.toString().length;
    if(abc==0)
    {
        document.getElementById('sid').style.borderColor="red";
        document.getElementById('err8').innerText="This field is required";
        document.getElementById('suc_8').style.visibility="hidden";
        document.getElementById('fail_8').style.visibility="visible";
    }
    else if(abc==9)
    {
        document.getElementById('sid').style.borderColor="green";
        document.getElementById('err8').innerText="";
        document.getElementById('fail_8').style.visibility="hidden";
        document.getElementById('suc_8').style.visibility="visible";
    }
    else
    {
        document.getElementById('sid').style.borderColor="red";
        document.getElementById('err8').innerText="must be contain 9 digits";
        document.getElementById('suc_8').style.visibility="hidden";
        document.getElementById('fail_8').style.visibility="visible";
    }
}

function CheckpasswordStd()
{
	const data=document.getElementById('spassword').value;
    const abc=data.length;
    if(abc==0)
    {
        document.getElementById('spassword').style.borderColor="red";
        document.getElementById('err9').innerText="password field is required";
        document.getElementById('suc_9').style.visibility="hidden";
        document.getElementById('fail_9').style.visibility="visible";
    }
    else if(abc>=8 && abc<=25)
    {
		document.getElementById('spassword').style.borderColor="green";
        document.getElementById('err9').innerText="";
        document.getElementById('fail_9').style.visibility="hidden";
        document.getElementById('suc_9').style.visibility="visible";
    }
    else
    {
		document.getElementById('spassword').style.borderColor="red";
        document.getElementById('err9').innerText="must be >=8 and <=25";
        document.getElementById('suc_9').style.visibility="hidden";
        document.getElementById('fail_9').style.visibility="visible";
    }
}

function CheckpasswordMen()
{
	const data=document.getElementById('mpassword').value;
    const abc=data.length;
    if(abc==0)
    {
        document.getElementById('mpassword').style.borderColor="red";
        document.getElementById('err5').innerText="password field is required";
        document.getElementById('suc_5').style.visibility="hidden";
        document.getElementById('fail_5').style.visibility="visible";
    }
    else if(abc>=8 && abc<=25)
    {
		document.getElementById('mpassword').style.borderColor="green";
        document.getElementById('err5').innerText="";
        document.getElementById('fail_5').style.visibility="hidden";
        document.getElementById('suc_5').style.visibility="visible";
    }
    else
    {
		document.getElementById('mpassword').style.borderColor="red";
        document.getElementById('err5').innerText="must be >=8 and <=25";
        document.getElementById('suc_5').style.visibility="hidden";
        document.getElementById('fail_5').style.visibility="visible";
    }
}

function Submit(){}