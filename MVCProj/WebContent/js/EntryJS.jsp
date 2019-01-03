$(document).ready(function()
{



xmlHttpRequest.open("Get", "/MVCProj/GetEntriesController", true);
xmlHttpRequest.onreadystatechange = processEntries;
xmlHttpRequest.send(null);


}
);