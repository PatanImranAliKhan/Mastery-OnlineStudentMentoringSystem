function CheckName()
{
    var name=document.getElementById('name').value;
    const len=name.length;
    if(len==0)
    {
        document.getElementById('name').style.borderColor="red";
        document.getElementById('err1').innerText="This field is required";
        document.getElementById('suc_1').style.visibility="hidden";
        document.getElementById('fail_1').style.visibility="visible";
    }
    else if(len <3)
    {
        document.getElementById('name').style.borderColor="red";
        document.getElementById('err1').innerText="text must be atleast 3 digits";
        document.getElementById('suc_1').style.visibility="hidden";
        document.getElementById('fail_1').style.visibility="visible";
    }
    else
    {
        document.getElementById('name').style.borderColor="green";
        document.getElementById('err1').innerText="";
        document.getElementById('fail_1').style.visibility="hidden";
        document.getElementById('suc_1').style.visibility="visible";
    }
}

function CheckCode()
{
    var code=document.getElementById('code').value;
    const len=code.length;
    if(len==0)
    {
        document.getElementById('code').style.borderColor="red";
        document.getElementById('err2').innerText="This field is required";
        document.getElementById('suc_2').style.visibility="hidden";
        document.getElementById('fail_2').style.visibility="visible";
    }
    else if(len!=6)
    {
        document.getElementById('code').style.borderColor="red";
        document.getElementById('err2').innerText="text must be 6 digits";
        document.getElementById('suc_2').style.visibility="hidden";
        document.getElementById('fail_2').style.visibility="visible";
    }
    else
    {
        console.log();
        if(/[A-Z]{2}\d{3}/i.test(code))
        {
            document.getElementById('code').style.borderColor="green";
            document.getElementById('err2').innerText="";
            document.getElementById('fail_2').style.visibility="hidden";
            document.getElementById('suc_2').style.visibility="visible";
        }
        else
        {
            document.getElementById('code').style.borderColor="red";
            document.getElementById('err2').innerText="Must be in the order 'MT2105'";
            document.getElementById('suc_2').style.visibility="hidden";
            document.getElementById('fail_2').style.visibility="visible";
        }
    }
}