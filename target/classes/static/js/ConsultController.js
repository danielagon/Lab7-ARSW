/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ConsultControllerModule = (function (){
    
    
    var getConsult = function(id, type){
        
        var callback = {
            onSuccess: function(response){
                alert("ENTRA 1");
                //var json = JSON.parse(response);
                $('#tableConsult').empty();
                $('#tableConsult').append("<thead> <tr> <th class='col'>Date</th> <th class='col'>Open</th> <th class='col'>High</th> <th class='col'>Low</th> <th class='col'>Close</th> <th class='col'>Volume</th> </tr> </thead>");
                $('#tableConsult').append("<tbody> <tr> <td> <a>'"+response+"'</a> </td> </tr> </tbody>");
                alert(response[0]);
            },
            onFailed: function(exception){
                console.log(exception);
                alert("There is a problem with our servers.");
            }
        };
        RestControllerModule.getConsult(id,type,callback);
    };
    
    return {
        getConsult: getConsult
    };
})();    