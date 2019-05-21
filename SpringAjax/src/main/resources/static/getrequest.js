$(document).ready({
    function(){

        //get request
        $("#getAllBooks").click(function(event){
            event.preventDefault();
            ajaxGet();
        });

        //DO GET
        function ajaxGet(){
            $.ajax({
                type : "GET",
                url : window.location + "getAllBooks",
                success : function(result){
                    if(result.status == "success"){
                        $("#getResultDiv ul").empty();

                        var custList ="";
                        $.each(result.data, function(i, order){
                            var user = "Book Name " + book.bookName
                                    + ", Author = " + book.author +" <br>";
                            $("#getResultDiv .list-group").append(user);

                        });
                        console.log(" Success: ", result);
                    }else{
                        $("getResultDiv").html("<strong>Error</strong>")
                        console.log("Fail: ", result);
                    }
                },
                error : function(e){
                                    alert("error");
                                    console.log("Error: ", e);
                                }
            });
        }
    }
});