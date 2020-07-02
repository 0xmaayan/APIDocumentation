<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div>
        <div class="col-lg-12 col-sm-12">
            <h3>Endpoints Documentation</h3>
        </div>
    </div>
    <div class="col-lg-12">
        
        <div class="row" style="margin-bottom:40px">
            <div class="col-md-3">
                <div>
                    <label>Type Endpoint to search for</label>
                </div>
                <div>
                    <input style="width:100%;" type="text" id="apiInputText"/>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-3">
                <div>
                    <label><input type="checkbox" checked name="service" value="service1"/>Service 1</label>
                </div>
            </div>
            <div class="col-md-3">
                <div>
                    <label><input type="checkbox" name="service" disabled value="service2"/>Service 2</label>
                </div>
            </div>
            <div class="col-md-3">
                <div>
                    <label><input type="checkbox" name="service" disabled value="service3"/>Service 3</label>
                </div>
            </div>
            <div class="col-md-3">
                <div>
                    <label><input type="checkbox" name="service" disabled value="service4"/>Service 4</label>
                </div>
            </div>
        </div>
        
        
        <div class="row">
            <div class="col-md-3">
                <div id="service1DataWrapper" data-service="Service 1"></div>
            </div>
            <div class="col-md-3">
                <div id="service2DataWrapper" data-service="Service 2"></div>
            </div>
            <div class="col-md-3">
                <div id="service3DataWrapper" data-service="Service 3"></div>
            </div>
            <div class="col-md-3">
                <div id="service4DataWrapper" data-service="Service 4"></div>
            </div>
        </div>
    </div>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.15/lodash.core.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.15/lodash.min.js"></script>

<script src="/js/index.js" type="text/javascript"></script>

</html>