<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.zkoss.org/dsp/zk/core" prefix="z" %>
<c:include page="~./zul/css/ext.css.dsp"/>

 .longWidth  .z-textbox-rounded-inp {
        width: 280px;
}
 .mediumWidth  .z-textbox-rounded-inp {
        width: 170px;
}

 .longWidth  .z-intbox-rounded-inp {
        width: 280px;
}
 .mediumWidth  .z-intbox-rounded-inp {
        width: 170px;
}

 .longWidth  .z-combobox-rounded-inp {
        width: 260px;
}  
 .mediumWidth  .z-combobox-rounded-inp {
        width: 80px;
}  

     
tr.z-grid-odd td.z-row-inner,tr.z-grid-odd .z-cell,tr.z-grid-odd{
        background:#C1CDF5
        }
tr.z-row td.z-row-inner,tr.z-row .z-cell{
        background:white;
        border-top:none;
        border-left:0px solid white;
        border-right:0px solid #CCC;
        border-bottom:0px solid #DDD;
        padding:3px;
}
${z:setCSSCacheControl()}

html {overflow:auto;}
img { -ms-interpolation-mode:bicubic }
body {
	padding: 0 !important;
}
h4 {
	margin: 0;
	padding: 10px 0;
}
P {
	margin: 0;
	padding: 5px 0;
}
ul {
	margin-top: 5px;
	margin-bottom: 5px;
}
a, a:visited {
	color:#008bb6;
}
ul li	{list-style: url(${c:encodeURL(c:browser('ie6-') ? '/img/z-bullet1.gif' : '/img/Centigrade-Widget-Icons/Bullet-10x10.png')}) disc}
ul ul li	{list-style: url(${c:encodeURL('/img/z-bullet2.gif')}) circle}
ul ul ul li	{list-style: url(${c:encodeURL('/img/z-bullet3.gif')}) square}
.os-header .z-north-body {
	background:transparent url(${c:encodeURL('/img/category-bg.png')}) repeat-x scroll 0 0;
}
.os-categorybar {
	position: relative;	
	overflow: hidden;
	float:center;
	padding-left:10px;
	${c:browser('ie6-') ? 'float: left;' : ''}
}
.os-categorybar-body {
	margin: 0px;
	align: right;
	width: 100%;
	overflow: hidden;
	zoom: 1;
}
.os-categorybar-body-scroll {
	position: relative;
	margin-left: 20px;
	margin-right: 20px;
}
.os-categorybar-right-scroll {
	background-color: transparent;
	background-image: url(${c:encodeURL('/img/scroll-right.png')});
	background-repeat: no-repeat;
	background-attachment: scroll;
	background-position: 0 0;
	border-bottom: 1px solid #8DB2E3;
	cursor:pointer;
	position:absolute;
	right:0;
	top:37px;
	width:18px;
	z-index:10;
	height:25px;
}
.os-categorybar-right-scroll:hover {
	background-position: -18px 0;
}
.os-categorybar-left-scroll {
	background-color: transparent;
	background-image: url(${c:encodeURL('/img/scroll-left.png')});
	background-repeat: no-repeat;
	background-attachment: scroll;
	background-position: -18px 0;
	border-bottom:1px solid #8DB2E3;
	cursor:pointer;
	left:0;
	position:absolute;
	top:37px;
	width:18px;
	z-index:10;
	height:25px;
}
.os-categorybar-left-scroll:hover {
	background-position: 0 0;
}
.os-seld {
	background:transparent url(${c:encodeURL('/img/category-seld.png')}) no-repeat scroll 0 0;
}
.os-over.os-seld {
	background:transparent url(${c:encodeURL('/img/category-over-seld.png')}) no-repeat scroll 0 0;
}
.os-over {
	background:transparent url(${c:encodeURL('/img/category-over.png')}) no-repeat scroll 0 0;
}
.os-search-inp {
    padding: 2px 0 1px 18px;
	background: white url(${c:encodeURL(c:browser('ie6-') ? '/img/search.gif' : '/img/search.png')}) no-repeat scroll 0 0;
}
.os-category {
	margin-top: 10px; float:left; height: 80px; width: 90px;
	padding-top:7px;
	text-align:center;
	cursor: pointer;
}
.os-category-img {
	width: 48px;
	height: 48px;
}
.os-category-text {
	color: #1c5178; font-size:10px;
}
.os-logo {
	padding: 10px 20px 0 10px;
	float:right;
}
div.os-items {
	border: 0; background: white;
}
.os-items .z-listbox-body {
	overflow-x: hidden;
}
.os-items .z-listcell-cnt img {
	width:24px;
	height:24px;
}
.os-items .z-listcell-cnt {
	padding-left: 5px;
}
.os-main-cnt {
	padding-left: 5px;
}
.os-main-desc {
	padding-bottom: 5px;
}
.pointer {
	cursor:pointer;
}
.edition-field, .edition-field:visited {
	color: #346B93;
	text-decoration: none;
	font-style: italic;
}
a.edition-field:hover {
	text-decoration: underline;
}

<%-- Sapphire --%>
.sapphire .os-header .z-north-body {
	background-image: url(${c:encodeURL('/img/breeze-category-bg.png')});
}
.sapphire .os-categorybar .os-seld {
	background-image: url(${c:encodeURL('/img/g-category-seld.png')});
}
.sapphire .os-categorybar .os-over {
	background-image: url(${c:encodeURL('/img/g-category-over.png')});
}
.sapphire .os-categorybar .os-seld.os-over {
	background-image: url(${c:encodeURL('/img/g-category-over-seld.png')});
}
.sapphire .os-categorybar-left-scroll {
	background-image: url(${c:encodeURL('/img/g-scroll-left.png')});
	border-bottom: 1px solid #B7B7B7;
}
.sapphire .os-categorybar-right-scroll {
	background-image: url(${c:encodeURL('/img/g-scroll-right.png')});
	border-bottom: 1px solid #B7B7B7;
}

<c:if test="${c:browser('ie6-')}">
.sapphire .os-categorybar-left-scroll {
	background-image: none;
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=crop, src="${c:encodeURL('/img/breeze-arrow-left.png')}");
}
.sapphire .os-categorybar-right-scroll {
	background-image: none;
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=crop, src="${c:encodeURL('/img/breeze-arrow-right.png')}");
}
</c:if>

<%-- Silvertail --%>
.silvertail .os-header .z-north-body {
	background-image: url(${c:encodeURL('/img/g-category-bg.png')});
}
.silvertail .os-categorybar .os-seld {
	background-image: url(${c:encodeURL('/img/g-category-seld.png')});
}
.silvertail .os-categorybar .os-over {
	background-image: url(${c:encodeURL('/img/g-category-over.png')});
}
.silvertail .os-categorybar .os-seld.os-over {
	background-image: url(${c:encodeURL('/img/g-category-over-seld.png')});
}
.silvertail .os-categorybar-left-scroll {
	background-image: url(${c:encodeURL('/img/g-scroll-left.png')});
	border-bottom: 1px solid #B7B7B7;
}
.silvertail .os-categorybar-right-scroll {
	background-image: url(${c:encodeURL('/img/g-scroll-right.png')});
	border-bottom: 1px solid #B7B7B7;
}

<c:if test="${c:browser('ie6-')}">
.silvertail .os-categorybar-left-scroll {
	background-image: none;
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=crop, src="${c:encodeURL('/img/breeze-arrow-left.png')}");
}
.silvertail .os-categorybar-right-scroll {
	background-image: none;
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=crop, src="${c:encodeURL('/img/breeze-arrow-right.png')}");
}
</c:if>

<%-- Breeze --%>
.breeze .os-header .z-north-body {
	background-image: url(${c:encodeURL('/img/breeze-category-bg.png')});
}
.breeze .os-categorybar .os-seld {
	background-image: url(${c:encodeURL('/img/g-category-seld.png')});
}
.breeze .os-categorybar .os-over {
	background-image: url(${c:encodeURL('/img/g-category-over.png')});
}
.breeze .os-categorybar .os-seld.os-over {
	background-image: url(${c:encodeURL('/img/g-category-over-seld.png')});
}
.breeze .os-categorybar-left-scroll,
.breeze .os-categorybar-right-scroll {
	border: 0;
	width: 17px;
	height: 27px;
	top: 36px;
}
.breeze .os-categorybar-body-scroll {
	margin-left: 22px;
	margin-right: 22px;
}
.breeze .os-categorybar-left-scroll {
	background-image: url(${c:encodeURL('/img/breeze-arrow-left.png')});
	background-position: 0 0;
}
.breeze .os-categorybar-left-scroll:hover {
	background-position: right 0;
}
.breeze .os-categorybar-right-scroll {
	background-image: url(${c:encodeURL('/img/breeze-arrow-right.png')});
	background-position: right 0;
}
.breeze .os-categorybar-right-scroll:hover {
	background-position: 0 0;
}
<c:if test="${c:browser('ie6-')}">
.breeze .os-categorybar-left-scroll {
	background-image: none;
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=crop, src="${c:encodeURL('/img/breeze-arrow-left.png')}");
}
.breeze .os-categorybar-right-scroll {
	background-image: none;
	filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=crop, src="${c:encodeURL('/img/breeze-arrow-right.png')}");
}
</c:if>