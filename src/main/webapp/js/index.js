

var EndpointDocumentation = function () {
    var self = this;
    this.serviceToLookOn = ["service1"];
};

EndpointDocumentation.prototype.renderDataHtml = function(data,service) {
    var html = "";
    data.forEach(element => {
        html += '<hr>';
        html += '<p><strong>'+element.requestType+'</strong></p>';
        html += '<p ><strong style="user-select:text;">'+element.url+'</strong></p>';

        html += '<div class="span-3 colborder">';
        html += '<p style="user-select:text;"><strong><span class="alt">File Name: </span></strong>'+element.fileName+'</p>';
        html += '</div>';

        html += '<div class="span-3 colborder">';
        html += '<p style="user-select:text;"><strong><span class="alt">Method Name: </span></strong>'+element.methodName+'</p>';
        html += '</div>';

        html += '<div class="span-3 colborder">';
        html += '<p><strong><span class="alt">Return Type: </span></strong>'+element.returnType+'</p>';
        html += '</div>';
        
        if(element.parameters){
            html += '<div class="span-3 colborder">';
            html += '<p><strong><span class="alt">Parameters: </span></strong>';
            let parametersArr = element.parameters.split(",");
            parametersArr.forEach(parameter => {
                html += '</br>';
                html += parameter;
            })
            html += '</p>';
            html += '</div>';

        }
        
    });
    
    $(`#${service}DataWrapper`).html(html);
}

EndpointDocumentation.prototype.getAPIByName = function(text, service) {
    
    var _this = this;
    $.ajax({
        async : false, 
        type : 'GET',
        headers: {"Access-Control-Allow-Origin" : "*"},
        url : 'http://localhost:8080/apidoc?text=' + text,
        success : function(data) {
            if(typeof data === "string"){
                data = JSON.parse(data);
            }
            _this.renderDataHtml(data, service);
        },
        error : function(error) {
            console.log(error);
        }
    });
}

EndpointDocumentation.prototype.emptyDataUI = function (service) {
    let divAttr = $("div").find(`[data-service='${service}']`)
    divAttr.empty();
}

EndpointDocumentation.prototype.registerEvents = function() {
    
    var _this = this;
    
    $('#apiInputText').keyup(_.debounce(function(e){
        let value = e.target.value;
        if(value.length !== 0){
            _this.serviceToLookOn.forEach(service => {
                _this.getAPIByName(value, service);
            });
        }else{
            _this.serviceToLookOn.forEach(service => {
                _this.emptyDataUI(service);
            })
        }
    },500));


    $("input[type='checkbox'][name='service']").click(function(e) {
        let service = e.target.value;
        const exists = _this.serviceToLookOn.includes(service);
        if(!exists) {
            _this.serviceToLookOn.push(service)
            let value = $('#apiInputText').val();
            if(value !== ""){
                _this.getAPIByName(value, service);
            }
        }else{
            if(_this.serviceToLookOn.length === 1) {
                e.stopPropagation();
                e.preventDefault();
                return false;
            };
            var index = _this.serviceToLookOn.indexOf(service);
            if (index !== -1) _this.serviceToLookOn.splice(index, 1);
            _this.emptyDataUI(service);
        }

    })

}


var initialize = function () {

    var endpointDocumentation = new EndpointDocumentation();

    $(document).ready(function () {
        endpointDocumentation.registerEvents();
    });
}

initialize()