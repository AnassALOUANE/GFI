function resetClass()
    {
		var uls = document.getElementsByClassName("current");			   
		uls[0].className = "select";
		
		

    }
	
	function selectGU()
    {	resetClass();
		var parentElement = document.getElementById("GU").className = "current";
		
	}
	function selectGM()
    {	resetClass();
		var parentElement = document.getElementById("GM").className = "current";
		
	}
	function selectGP()
    {	resetClass();
		var parentElement = document.getElementById("GP").className = "current";
		
	}
	function selectGC()
    {	resetClass();
		var parentElement = document.getElementById("GC").className = "current";
		
	}
	function selectAP()
    {	resetClass();
		var parentElement = document.getElementById("AP").className = "current";	
		
	}
	window.onload = function()
    {
        document.getElementById("AP").addEventListener( 'click' , selectAP );
		document.getElementById("GU").addEventListener( 'click' , selectGU );
		document.getElementById("GM").addEventListener( 'click' , selectGM );
		document.getElementById("GC").addEventListener( 'click' , selectGC );
		document.getElementById("GP").addEventListener( 'click' , selectGP );
    }
	
	function showSub(obj) {
	var ils = document.getElementsByClassName("sub_show");	
			
		for(var i = 0; i < ils.length; i++){
			ils[i].className = "";
		}
        obj.className = "sub_show";
}