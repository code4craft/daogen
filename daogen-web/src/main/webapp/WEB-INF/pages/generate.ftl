<#setting url_escaping_charset='utf-8'>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,width=device-width,height=device-height,target-densitydpi=device-dpi,user-scalable=yes" />
    <title>Dao生成器</title>

    <!-- fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/app/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/app/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/app/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/app/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="assets/app/ico/favico.png">
    <link rel="shortcut icon" href="assets/app/ico/favico.ico">

    <!-- theme fonts -->
    <!--<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300italic,300,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>-->

    <!-- theme bootstrap stylesheets -->
    <link href="assets/bootstrap/css/bootstrap.css" rel="stylesheet" />

    <!-- theme dependencies stylesheets -->
    <link href="assets/app/css/dependencies.css" rel="stylesheet" />

    <!-- theme app main.css (this import of all custom css, you can use requirejs for optimizeCss or grunt to optimize them all) -->
    <link href="assets/app/css/syrena-admin.css" rel="stylesheet" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <style>
        .controls > input,
        .controls > select,
        .controls > .row,
        .controls > .input-group,
        .controls > .form-group > .input-group{
            margin-bottom: 15px;
        }
    </style>
</head>

<body>
<!-- content wrapper to define fullpage or container -->
<!-- (recomended: dont change the id value) -->
<section id="wrapper" class="container">
<!-- define side left theme -->

<!-- define content theme, use data-swipe="true" to enable gesture event -->
<!-- (recomended: dont change the id value) -->
<section id="content" class="content content-lg">
<!-- define your content header here -->
<header class="content-header">
    <!-- header actions -->
    <div class="header-actions pull-left">
        <!-- (recomended: dont change the id value) -->
    </div><!-- /header actions -->

    <!-- your Awesome App title -->
    <h1 class="content-title">Dao生成器</h1>
</header><!-- /side left -->


<!-- define content row -->
<div class="content-spliter">
<!-- define your awesome apps here -->
<!-- (recomended: dont change the id value) -->
<section id="content-main" class="content-main">

<!-- your app content -->
<div class="content-app fixed-header">
<!-- app header -->
<!-- app body -->
<div class="app-body">

<!-- app content here -->
<div class="magic-layout">
<div class="box magic-element width-full">
    <h2 class="box-heading">
        <div class="btn-group pull-right">
            <a href="#" role="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown">
                <i class="icon ion-ios7-arrow-down"></i>
            </a>
            <ul class="dropdown-menu" role="menu">
                <li><a class="form-theme" data-toggle="default" href="#">Default</a></li>
                <li><a class="form-theme" data-toggle="flat" href="#">Flat</a></li>
                <li><a class="form-theme" data-toggle="ion" href="#">Ion</a></li>
                <li class="divider"></li>
                <li><a class="form-theme" data-toggle="flat-ion" href="#">Flat & Ion</a></li>
                <li class="divider"></li>
                <li><a class="form-theme" data-toggle="disabled-fieldset" href="#">Toggle Disable</a></li>
            </ul>
        </div>
        查看结果
    </h2>
        <fieldset>
            <div class="form-group">
                <label class="col-sm-10 control-label" for="inputTextarea"><h3>${model.name}Entity.java</h3></label>
                <div class="col-sm-20">
                    <textarea rows="20" class="form-control">${entity}</textarea>
                </div>
            </div><!-- /form-group -->
            <div class="form-group">
                <label class="col-sm-10 control-label" for="inputTextarea"><h3>${model.name}Dao.java</h3></label>
                <div class="col-sm-20">
                    <textarea rows="20" class="form-control">${dao}</textarea>
                </div>
            </div><!-- /form-group -->
            <div class="form-group">
                <label class="col-sm-10 control-label" for="inputTextarea"><h3>${model.name}.xml</h3></label>
                <div class="col-sm-20">
                    <textarea rows="20" class="form-control">${sqlMap}</textarea>
                </div>
            </div><!-- /form-group -->
            <div class="form-group">
                <label class="col-sm-10 control-label" for="inputTextarea"><h3>${model.name}DaoTest.java</h3></label>
                <div class="col-sm-20">
                    <textarea rows="20" class="form-control">${test}</textarea>
                </div>
            </div><!-- /form-group -->
            <div class="form-group">
                <label class="col-sm-10 control-label" for="inputTextarea"><h3>AbstractDAOTest.java(供参考)</h3></label>
                <div class="col-sm-20">
                    <textarea rows="20" class="form-control">
package com.dianping.tuangou.navi.dal.dao.test;

import junit.framework.Assert;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/local/appcontext-*.xml","classpath*:config/spring/common/appcontext-*.xml" })
public abstract class AbstractDAOTest {

    protected void print(Object obj) {
        System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE));
    }

    private long start;

    public void notNull(Object obj) {
        assertNotNull(obj);
    }

    public void isNull(Object obj) {
        assertNull(obj);
    }

    public void equal(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }

    public void start() {
        this.start = System.currentTimeMillis();
    }

    public void end() {
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + "ms");
    }
}
                    </textarea>
                </div>
            </div><!-- /form-group -->
            <div class="form-group">
                <label class="col-sm-10 control-label" for="inputTextarea"><h3>appcontext-xxx-dao.xml</h3></label>
                <div class="col-sm-20">
                    <textarea rows="10" class="form-control">${springConfig}</textarea>
                </div>
            </div><!-- /form-group -->
        </fieldset><!-- /fieldset -->
    <div>另外，别忘了sqlmap-config.xml的配置！欢迎参与项目<a href="http://code.dianpingoa.com/yihua.huang/daogen/">http://code.dianpingoa.com/yihua.huang/daogen/</a>，更多功能敬请期待！</div>
</div><!-- /box -->


<!-- jQuery, theme required for theme -->
<script src="assets/jquery/jquery.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- theme dependencies -->
<!--
    Contents List
    1. Raphaël
    2. Isotope
    3. verge
    4. Moment
    5. Prettify
-->
<script src="assets/app/js/dependencies.js"></script>

<!-- other dependencies -->
<script src="assets/jquery-icheck/jquery.icheck.min.js"></script>
<script src="assets/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script src="assets/select2/select2.min.js"></script>
<script src="assets/multiselect/js/jquery.multi-select.js"></script>
<script src="assets/bootstrap-jasny/js/inputmask.js"></script>
<script src="assets/bootstrap-jasny/js/fileinput.js"></script>
<script src="assets/moment/moment.min.js"></script>
<script src="assets/bootstrap3-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="assets/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="assets/mjaalnir-bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>
<script src="assets/jquery-simplecolorpicker/jquery.simplecolorpicker.js"></script>

<!-- theme app main.js -->
<script src="assets/app/js/main.js"></script>

<!-- theme app demo form_elements.js, remove this from your project -->
<script src="assets/app-demo/form_elements.js"></script>

<script type="text/javascript">

    $(function() {
        'use strict';

        // checkbox and radio with iCheck
        // Initialize all components iCheck
        $('.iCheck').each(function(){
            // var each element .iCheck
            var $this = $(this),
                    skin = $this.attr('data-skin'),
                    color = $this.attr('data-color'),
                    checkbox, radio, insert = '';

            /**
             * default usage skin
             *
             * Skins options:
             * @data-skin minimalis
             * @data-skin square
             * @data-skin flat
             * @data-skin line
             * @data-skin polaris
             * @data-skin futurico
             */
            if (skin === undefined) {
                checkbox = 'icheckbox_minimal';
                radio = 'iradio_minimal';
            }
            else{
                checkbox = 'icheckbox_' + skin;
                radio = 'iradio_' + skin;
            }

            /**
             * default usage color
             *
             * Available colors:
             * @data-color black
             * @data-color red
             * @data-color green
             * @data-color blue
             * @data-color aero
             * @data-color grey
             * @data-color orange
             * @data-color yellow
             * @data-color pink
             * @data-color purple
             */
            if (color !== undefined) {
                checkbox = checkbox + '-' + color;
                radio = radio + '-' + color;
            }

            // handle iCheck skin 'line'
            if (skin == 'line') {
                var label = $this.next(),
                        label_text = label.text();

                insert = '<div class="icheck_line-icon"></div>' + label_text;
                label.remove();
            }

            // initialize
            $this.iCheck({
                checkboxClass: checkbox,
                radioClass: radio,
                insert: insert,
                increaseArea: '20%' // optional
            });
        });
        // end iCheck



        // tags input
        $('#tags-input1').tagsInput({
            height: "32px",
            width:'auto',           // support percent (90%)
        });
        $('#tags-input2').tagsInput({
            width:'auto',
            defaultText: 'Add Tag',
            onChange: function(elem, elem_tags)
            {
                var languages = ['php','ruby','javascript'];
                $('.tag', elem_tags).each(function()
                {
                    if($(this).text().search(new RegExp('\\b(' + languages.join('|') + ')\\b')) >= 0){
                        $(this).css({
                            'border-color': '#2980b9',
                            'background-color': '#3498db',
                            'color': '#ecf0f1'
                        });
                    }
                });
            }
        });
        // manual style for .tagsinput
        $('div.tagsinput input').on('focus', function(){
            var tagsinput = $(this).parent().parent();
            tagsinput.addClass('focus');
        }).on('focusout', function(){
            var tagsinput = $(this).parent().parent();
            tagsinput.removeClass('focus');
        });
        // end tags input



        // select2
        $(".select2").select2();


        // multiselect
        $(".multiselect").multiSelect();


        // bootstrap3-datetimepicker
        $('#datetimepicker1').datetimepicker({
            icons : {
                time: 'icon ion-ios7-clock-outline',
                date: 'icon ion-ios7-calendar-outline',
                up:   'icon ion-ios7-arrow-up',
                down: 'icon ion-ios7-arrow-down'
            }
        });
        $('#datetimepicker2').datetimepicker({
            icons : {
                time: 'icon ion-ios7-clock-outline',
                date: 'icon ion-ios7-calendar-outline',
                up:   'icon ion-ios7-arrow-up',
                down: 'icon ion-ios7-arrow-down'
            },
            pickDate: false
        });
        $('#datetimepicker3').datetimepicker({
            icons : {
                time: 'icon ion-ios7-clock-outline',
                date: 'icon ion-ios7-calendar-outline',
                up:   'icon ion-ios7-arrow-up',
                down: 'icon ion-ios7-arrow-down'
            },
            pickTime: false
        });
        $('#datetimepicker4').datetimepicker({
            icons : {
                time: 'icon ion-ios7-clock-outline',
                date: 'icon ion-ios7-calendar-outline',
                up:   'icon ion-ios7-arrow-up',
                down: 'icon ion-ios7-arrow-down'
            }
        });



        // date range picker
        $('#daterangepicker1').daterangepicker();
        $('#daterangepicker2').daterangepicker(
                {
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
                        'Last 7 Days': [moment().subtract('days', 6), moment()],
                        'Last 30 Days': [moment().subtract('days', 29), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                    },
                    startDate: moment().subtract('days', 29),
                    endDate: moment()
                },
                function(start, end) {
                    $('#daterangepicker2 .text-date').text(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
        );




        // colorpicker
        $('.colorpicker').colorpicker();
        $('#simpleColorpicker1').simplecolorpicker({
            theme: 'glyphicons'
        });
        $('#simpleColorpicker2').simplecolorpicker({
            picker: true,
            theme: 'glyphicons'
        });
    });

</script>
</body>
</html>