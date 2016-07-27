/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use-strict;'
$(document).ready(function() {
    $("#submitBtn").click(function(){
         ajaxCall();
    });
    
    var ajaxCall=function(){
        var term=$("#term").val();
       $.get('DicServlet',{term: term})
               .done(success)
               .fail(failed);
    };
   
    function success(data) {
    // do something with the data
        var result=$("<ol>");
        var text=JSON.stringify(data);
        var obj = JSON.parse(text);
        for(var i in obj) {
            var word=(obj[i]);
            console.log(word[0]+" ("+word[1]+") "+" :: "+word[2]);
            result.append($("<li>"),{
                "innerHTML":word[0]+" ("+word[1]+") "+" :: "+word[2]
            });
           // result +="<li>"+word[0]+" ("+word[1]+") "+" :: "+word[2]+"</li>";
        }
      //  result+="</ol>";
        $("#result").html(result);
    }
    function failed(xhr, status, exception) {
            console.log(xhr, status, exception);
            var result="<p>Sorry Something went wrong. Please Try Again</p>";
            $("#result").html(result);
    }
               
   });
