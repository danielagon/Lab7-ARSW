/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var RestControllerModule = (function (){
    
    var getConsult = function (id, type, callback){
        alert("ENTRA 2");
        axios.get('/consult/'+id+'/'+type)
            .then(function (consult){
                callback.onSuccess(consult);
            })
            .catch(function (error){
                callback.onFailed(error);
            })
    };
    
    return {
        getConsult: getConsult
    };
})();
