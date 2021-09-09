var smallDiv = null;//存放小图的div
var zoomDiv = null;//阴影遮罩div
var zoomDivWidth = 0;
var smallDivWidth = 0;
var bigDiv = null;
var bigDivWidth ;
var bigDivImg = null;

window.onload = function(){
    smallDiv = document.getElementById('smallDiv');
    zoomDiv = document.getElementById('zoomDiv');

    console.log([smallDiv])

    //阴影部分的宽度
    zoomDivWidth = zoomDiv.style.width?  zoomDiv.style.width
        : document.defaultView.getComputedStyle(zoomDiv,null).width;
    zoomDivWidth = parseInt(zoomDivWidth)

    //小图div的宽度
    smallDivWidth = smallDiv.offsetWidth;

    bigDiv = document.getElementById('bigDiv')
    bigDivImg = document.getElementById('bigDiv').getElementsByTagName('img')[0];
    //放大容器的宽度
    bigDivWidth = bigDiv.style.width?  bigDiv.style.width
        : document.defaultView.getComputedStyle(bigDiv,null).width;
    bigDivWidth = parseInt(bigDivWidth)



    smallDiv.onmouseover = function(event){
        showZoomDiv()
    }


    smallDiv.onmouseout = function(event){

        //消失阴影遮罩
        zoomDiv.style.display = 'none';

        //消失大图部分
        bigDiv.style.display = 'none';
    }

    smallDiv.onmousemove = function(event){
        showZoomDiv()
    }
}

function showZoomDiv(event){
    //获取鼠标的位置
    var evt = event ? event : window.event;
    var pointX = evt.layerX; //evt.pageX;
    var pointY = evt.layerY //evt.pageY;

    //鼠标放在阴影的中心
    pointX = pointX - zoomDivWidth/2
    pointY = pointY -  zoomDivWidth/2

    //确定左边的左边界的值
    //pointX如果小于 zoomDiv 宽度半 pointX = zoomDiv 宽度半
    if(pointX <= 0){
        pointX = 0;
    }
    if(pointY <= 0){
        pointY = 0;
    }
    //pointX 右边界 只要鼠标坐标大于smallDiv的宽度-zoomDiv 宽度半
    if(pointX >= (smallDivWidth - zoomDivWidth)){
        pointX = smallDivWidth -  zoomDivWidth;
    }
    if(pointY >= (smallDivWidth - zoomDivWidth)){
        pointY = smallDivWidth -  zoomDivWidth;
    }

    zoomDiv.style.top = pointY + 'px'
    zoomDiv.style.left = pointX + 'px'

    //显示阴影遮罩
    zoomDiv.style.display = 'block';


    //显示大图部分
    bigDiv.style.display = 'block';
    bigDiv.style.position = 'absolute'
    var top = smallDiv.offsetTop;
    var left = smallDiv.offsetLeft;
    bigDiv.style.left = left + smallDivWidth + 50 + 'px'
    bigDiv.style.top = top + 'px'

    //小图上的坐标点和大图大致对应
    //小图坐标点的位置  *  (大图的实际尺寸/大图的容器的尺寸)
    var imgTop = -pointY * (bigDivImg.offsetHeight/bigDivWidth)
    var imgLeft = -pointX *(bigDivImg.offsetWidth/bigDivWidth)

    bigDivImg.style.top = imgTop + 'px';
    bigDivImg.style.left = imgLeft + 'px';
}