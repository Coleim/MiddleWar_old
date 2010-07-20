
function loadContent(url,div) {

	var httpRequest = false;

	if (window.XMLHttpRequest) { // Mozilla, Safari,...
		httpRequest = new XMLHttpRequest();
		if (httpRequest.overrideMimeType) {
			httpRequest.overrideMimeType('text/xml');
        }
    }
    else if (window.ActiveXObject) { // IE
    	try{
                httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch (e) {
                try {
                    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch (e) {}
        }
    }

    if (!httpRequest) {
		alert('Impossible de créer une instance XMLHTTP');
       	return false;
    }

	if(url != null)
   	{
    	httpRequest.open('GET', url, true);
        if(div != null){
            httpRequest.onreadystatechange = function() { setContenuHttpRequest(httpRequest,div); };
        }
	}

    httpRequest.send(null);

}

function setInnerHtml(html,div){
    document.getElementById(div).innerHTML = html;
}

function setContenuHttpRequest(httpRequest,div) {

	 switch (httpRequest.readyState){

		case 0 :
                        document.getElementById(div).innerHTML = 'Initialisation en cours...';
		break;

		case 1 :
			document.getElementById(div).innerHTML = 'Transfert des données en cours...';
		break;

		case 2 :
			document.getElementById(div).innerHTML = 'Données transferées';
		break;

		case 4 :

		if (httpRequest.status == 200) {
                    document.getElementById(div).innerHTML=httpRequest.responseText;
                }
                else {
                    document.getElementById(div).innerHTML=httpRequest.status;
                }

		break;
	}

}
