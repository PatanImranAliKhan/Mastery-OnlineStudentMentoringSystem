function EditName()
{
    document.getElementById('username').disabled=false;
}

function EditEmail()
{
    document.getElementById('email').disabled=false;
}

function EditMobile()
{
    document.getElementById('mobile').disabled=false;
}

function PasswordBlur()
{
    const data=document.getElementById('oldpass').value;
    const pass=document.getElementById('pass').value;
    console.log(data+"   "+pass);
    if(data==pass)
    {
        document.getElementById('newpass').disabled=false;
    }
    else
    {
        document.getElementById('newpass').disabled=true;
    }
}

function CheckPassword()
{
    const data=document.getElementById('newpass').value;
    const abc=data.length;
    if(abc==0)
    {
        document.getElementById('newpass').style.borderColor="red";
        document.getElementById('err').innerText="password field is required";
        document.getElementById('suc').style.visibility="hidden";
        document.getElementById('fail').style.visibility="visible";
    }
    else if(abc>=8 && abc<=25)
    {
		document.getElementById('newpass').style.borderColor="green";
        document.getElementById('err').innerText="";
        document.getElementById('fail').style.visibility="hidden";
        document.getElementById('suc').style.visibility="visible";
    }
    else
    {
		document.getElementById('newpass').style.borderColor="red";
        document.getElementById('err').innerText="must be >=8 and <=25";
        document.getElementById('suc').style.visibility="hidden";
        document.getElementById('fail').style.visibility="visible";
    }
}
function Cancel()
{
	window.history.back();
}