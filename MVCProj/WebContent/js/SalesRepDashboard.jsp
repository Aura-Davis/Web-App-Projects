$(document).ready(function()
{

xmlHttpRequest.open("Get", "/MVCProj/GetCitiesController", true);
xmlHttpRequest.onreadystatechange = processCities;
xmlHttpRequest.send(null);

}
);

