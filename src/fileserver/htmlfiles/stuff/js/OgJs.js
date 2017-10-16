/**
 * Created by Codename-tkc on 5/31/2017.
 */

/* BELOW IS THE VARIABLE THAT HOLDS ALL THE CLICKED (SELECTED) ITEMS*/
var holder;

const HOLDER_HEADER = "1265ersfkasjdfhkauicy9872093i542p4hgjchasidll";//header of the holder;

const HOLDER_DIVIDER = "17263781yedbasncbiwahdkuy71qyiut414144121989"; //divides two paths i.e in between paths for easy separation!

var fileCopied = false;

var current = "";
$(document).ready(function () {

    loadDoc();
    prepareHeader();
    $('.options > li').addClass('unclickableOption'); //making the options(copy,paste,cut...) unclickable by default;
    $('.videodiv,.audiodiv').draggable({
        cursor: "move"
    });
    $('.dropme').on('dragover', function (event) {
        event.preventDefault();
        $(this).css({'background': 'rgba(0,0,255,0.3)'})
    });
    $('.dropme').on('drop', function (event) {
        event.preventDefault();
        $(this).css({'background': 'transparent'})
        var files = event.target.files;
        $('#dropModalInfo').modal('open');
    });
    checkAuthAccess();
    rwA();
});

function prepareHeader() {       // Just a dummy function to introduce the header to the holder
    holder = HOLDER_HEADER;
}


/* THIS METHOD ADD TO LIST ALL THE FILES WHEN THEY ARE CLICKED WITH THE CONTROL KEY PRESSED*/
function addToList(encrpath) { //path should already be 'encr' (not raw);
    holder += encrpath + HOLDER_DIVIDER;
    console.log("adding|" + encrpath + "|");
    refreshOptionsButtons();
}


/* THIS METHOD ADD TO LIST ALL THE FILES WHEN THEY ARE UNCLICKED */
function removeFromList(encrpath) {  //path should already be 'encr' as well;
    holder = holder.replace(encrpath + HOLDER_DIVIDER, "");
    console.log("removing|" + encrpath + "|");
    refreshOptionsButtons();
}


/* This method is to get the number of elements present in holder!!*/
function getEltNumber() {
    return holder.replace(HOLDER_HEADER, "").split(HOLDER_DIVIDER).length - 1;
}


/* Returns a string of xters of the Various elts in the holder variable separated by a '|'  */
function getEltList() {
    var text = "";
    for (var i = 0; i < holder.replace(HOLDER_HEADER, "").split(HOLDER_DIVIDER).length; i++) {
        if (i < holder.replace(HOLDER_HEADER, "").split(HOLDER_DIVIDER).length - 2)
            text += holder.replace(HOLDER_HEADER, "").split(HOLDER_DIVIDER)[i] + "|";
        else
            text += holder.replace(HOLDER_HEADER, "").split(HOLDER_DIVIDER)[i];
    }
    return text;
}

function refreshOptionsButtons() {  //refresh the buttons as a function of the clicked items i.e when clickable and not :| + sidebuttons
    if (getEltNumber() > 0) {
        console.log("elements are greater than zero");
        $('.options > li').removeClass('unclickableOption');
        $('.options > li').addClass('clickableOption');
        $('.selectedFilesValue').text(getEltNumber());
        $('.paste').removeClass('clickableOption');
        $('.paste').addClass('unclickableOption');
    }
    else {
        console.log("elements are equal to zero");
        $('.options > li').removeClass('clickableOption');
        $('.options > li').addClass('unclickableOption');
        $('.selectedFilesValue').text('0');
        if (fileCopied) {
            $('.paste').removeClass('unclickableOption');
            $('.paste').addClass('clickableOption');
        }
    }

}


function emptyholder() {  // empty the contents of the selected items
    prepareHeader();
    $('.selectedFilesValue').text('0');
    $('.highlightedctrl').removeClass('highlightedctrl');
    $('.cut ,.copy ,.download , .delete').removeClass('clickableOption');
    $('.cut ,.copy ,.download , .delete').addClass('unclickableOption');
}

/*Below is a function to 'treat' holder on left mouse down ... it verifies whether you copied/cut something. if Not, it empties holder*/
function folderDown(ctx, event) {
    var path = ctx.getAttribute('path');
    path = encr(path);
    if (event.ctrlKey) {
        if ($(ctx).hasClass('highlightedctrl')) {
            $(ctx).removeClass('highlightedctrl');
            removeFromList(path);
        }
        else {
            $(ctx).addClass('highlightedctrl');

            addToList(path);
        }
    }
    else {
        //  path=path.replace("%","2163e87sabdiaduahbd7863t4e817tgebdhjaczz").replace("\\\\","/").replace("\'","ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645").replace("#","243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30");

        folderClick(path, 1, event);

    }
}

var previousresp = ""; // this whole the previous content of .me if not the same, .me is refreshed
function loadDoc() {  // load the drives...... this is the one which does the actual work not LoadMassa!!!!
    $('.loadDrivesMassa').html("<center>" +
        "<div class='circle turn' style='border:5px solid transparent;border-left: 5px solid #1a237e; width: 50px;height:50px;'>" +
        "</div></center>");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var jsonData = JSON.parse(this.response);
            console.log(jsonData);
            var resp = "";
            numberOfDrives = jsonData.length;
            for (var i = 0; i < jsonData.length; i++) {
                if (jsonData[i]["size"] == ".00 B")
                    resp += "<li  title='Error retrieving' style='text-decoration: line-through;'>" + jsonData[i]["Name"] + "<span class='new badge' style='position: relative;top:-10px;'>" + "Inaccessible" + "</span></li>";
                else
                    resp += "<li onclick='load(\"" + jsonData[i]["Name"].toUpperCase().replace("\\", "\\\\") + "\")' title='(Free Space: " + jsonData[i]["freeSpace"] + " )'>" + jsonData[i]["Name"] + "<span class='new badge' style='position: relative;top:-10px;'>" + jsonData[i]["size"] + "</span></li>";
            }
            if (previousresp != resp) {
                $('.me').html(resp);
                previousresp = resp;
            }
        }
    };
    xhttp.open("GET", "a010101110011010110011011" + encodeURI("getDrives").replace(":", "c001100900345711010n") + ".1j1s1o1n1", true);
    xhttp.send();
}

/*function load(url) {
 current=url;
 var getter = "a010101110011010110011011" + encodeURI(url).replace(":", "c001100900345711010n") + ".1j1s1o1n1";
 $('.body').html("<tr><td colspan='5'><center><div class='circle turn' style='border:5px solid transparent;border-left: 5px solid #1a237e; width: 100px;height:100px;'></div></center></td></tr>");
 $('.body').load(getter,function(){

 });
 //  xhttp.open("GET", "a010101110011010110011011" + encodeURI(url).replace(":", "c001100900345711010n") + ".1j1s1o1n1", true);

 }*/

function load(url, type) {
    if (type == '2') {
       var downloadPath = "/a010101110011010110011011" + removehashtag(url.replace(":", "c001100900345711010n"))+"/a010101110011010110011011";
        var anchor = document.createElement('a');
        anchor.href = downloadPath;
        anchor.download = url;
        anchor.target = '_blank';
        anchor.click();
    }
    else {

        current = url;
        var getter = "a010101110011010110011011" + encodeURI(removehashtag(url)).replace(":", "c001100900345711010n") + ".1j1s1o1n1";
        console.log(getter);
        $('.body').html("<tr><td colspan='5'><center><div class='circle turn' style='border:5px solid transparent;border-left: 5px solid #1a237e; width: 100px;height:100px;'></div></center></td></tr>");
        $('.body').load(getter, function () {
            $('.options').slideDown(300);
        });
    }
}

/*$('.folder').mousedown(function(e){
 //var path=  $(this).attr('path');
 if(e.button==2){
 alert('click');
 // $('.menu').css('left', e.pageX);
 //  $('.menu').css('top', e.pageY);
 //   $('.menu').delay(360).fadeIn(360);

 }
 else{
 //    load(path.replace("\\","\\\\"));
 }
 });*/
/*
 $(window).click(function(e){
 if(e.button==0){
 $('.menu').delay(360).fadeOut(360);}
 });*/
var workingExt = "";

function remmovespec(split2) {
    var response = decr(split2);
    for (var i = 0; i < split2.split("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").length; i++) {
    //    response = remmovespec.replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'");
    }
    return  split2.split("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645").join("\'");
}

function folderClick(url, type, event) {
    emptyholder();
    url = remmovespec(url);
    if (event.button == 2) {
        var split = url.split('/');//.split("/");
        var rename = remmovespec(split[split.length - 1]);    //remove <<'>>     //.replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645","\'");
        console.log("rename: " + rename);
        if (type == 1) {
            $('.open').text("Open");
            $('.mkdir').show(0);
            $('.open').attr('type', 1);
            $('#rename').val(rename);
            workingExt = "";
        }
        else {
            $('.open').text("Download");
            $('.mkdir').hide(0);
            $('.open').attr('type', 2);
            var renamesplit = rename.split('.');
            var actualrename = "";
            for (var i = 0; i < renamesplit.length - 1; i++) {
                actualrename += renamesplit[i];
                if (i != renamesplit.length - 2) {
                    actualrename += ".";
                }
            }
            $('#rename').val(actualrename);
            workingExt = "." + renamesplit[renamesplit.length - 1];
        }


        $('.open').attr('path', url);


        if ((event.pageY + $(".menu").height()) > $(window).height()) {
            $('.menu').css('top', event.pageY - 6 - $('.menu').height());
        }
        else {
            $('.menu').css('top', event.pageY + 6);
        }

        if ((event.pageX + $(".menu").width()) > $(window).width()) {
            $('.menu').css('left', event.pageX - 6 - $('.menu').width());
        }
        else {
            $('.menu').css('left', event.pageX + 6);
        }
        $('.menu').show();
    }
    else {
        if (type == 2) {
            var ThePath = "/a010101110011010110011011" + url.replace(":", "c001100900345711010n")+"/a010101110011010110011011";
            var anchor = document.createElement('a');
            anchor.href = ThePath;
            anchor.download = url;
            anchor.target = '_blank';
            anchor.click();
        }
        else {
            load(url);
        }
    }
}

$(window).mousedown(function (event) {

    if (event.button == 0) {
        $('.menu').hide();
    }

});

function indicate() {
    $('#rename').val(removespecialrenamecharacters($('#rename').val()));
    $('.showme').text("New Name: " + removespecialrenamecharacters($('#rename').val()) + workingExt);
}

function mkdirindicate() {
    $('.showmeMkdir').text("New Name: " + removespecialrenamecharacters($('#mkdir').val()) + workingExt);

}

function removespecialrenamecharacters(name) {
    var returnedString = name;
    for (var i = 0; i < name.split("\\").length; i++) {
        returnedString = returnedString.replace("\\", "");
    }
    for (var j = 0; j < name.split("/").length; j++) {
        returnedString = returnedString.replace("/", "");
    }
    for (var k = 0; k < name.split("<").length; k++) {
        returnedString = returnedString.replace("<", "");
    }
    for (var l = 0; l < name.split(">").length; l++) {
        returnedString = returnedString.replace(">", "");
    }
    for (var m = 0; m < name.split("\"").length; m++) {
        returnedString = returnedString.replace("\"", "");
    }
    for (var o = 0; o < name.split(":").length; o++) {
        returnedString = returnedString.replace(":", "");
    }
    for (var p = 0; p < name.split("?").length; p++) {
        returnedString = returnedString.replace("?", "");
    }
    for (var q = 0; q < name.split("*").length; q++) {
        returnedString = returnedString.replace("*", "")
    }
    for (var r = 0; r < name.split("|").length; r++) {
        returnedString = returnedString.replace("*", "")
    }

    return returnedString;
}

function replacewithinvertedcomma(name) { //replace crazy character with inverted comma <<'>>
    var returnedString = name;
    for (var i = 0; i < name.split("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645").length; i++) {
        returnedString = returnedString.replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'");
    }
    return returnedString;
}

function removehashtag(text) {
    return text.replace("#", "243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30");
}
//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
function rename(path, name) {
    path = reconstitute(removehashtag(path), "ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645");
    console.log("path:" + path);
    $('.showme').text('');
    var url = "0001200oieuahdjsbco13846t9eqd7gvizcm1o2371" + removehashtag(replacewithinvertedcomma(name)) + workingExt;
    console.log("url: " + url);
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText == "true") {
                Materialize.toast('Rename Successful', 3000, 'rounded');
                load(current);
            }
            else
                Materialize.toast('Rename Unsuccessful', 3000, 'rounded');
            //  alert(this.responseText);

        }
    };
    //</editor-fold>

    xhttp.open("GET", "/a010101110011010110011011" + encodeURI(path).replace(":", "c001100900345711010n") + encodeURI(url) + ".1r1e1n1a1m1e1", true);
    xhttp.send();
    $('#modal1').modal('close');
}

function deletefile(path) {
    $('.delnotification').show(300);
    $('.showme').text('');
    console.log("deleting: " + removehashtag(path));
    // var url="0001200oieuahdjsbco13846t9eqd7gvizcm1o2371"+name.replace("\\","").replace("/","").replace("<","").replace(">","").replace("\"","").replace("\'","").replace(":","").replace("?","").replace("*","");
    var url = removehashtag(path);

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText == "true") {
                Materialize.toast('Delete Successful', 3000, 'rounded');
                load(current.replace("#", "243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30"));
                $('.indicator').text('Done deleting ' + path);
            }
            else {
                Materialize.toast('Delete Unsuccessful', 3000, 'rounded');
                $('.indicator').text('Couldn\'t delete ' + path);
            }
            //  alert(this.responseText);
            $('.delnotification').hide(300);
        }
    };

    xhttp.open("GET", "/a010101110011010110011011" + encodeURI(removehashtag(path)).replace(":", "c001100900345711010n") + "" + ".1d1e1l1e1t1e1", true);
    xhttp.send();
    $('#modal1').modal('close');
}

var myJsonLength = 0;
var constitutedString = "";
var numberOfDrives;

/*function loadDrivesMassa() { // function was an old one.. had to keep it aside to avoid conflicts with LoadDoc();

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var jsonData = JSON.parse(this.responseText);
            console.log(jsonData);
            var resp = "";
            myJsonLength = 0;
            for (var i = 0; i < jsonData.length; i++) {
                if (jsonData[i]["size"] != ".00B") {
                    var text = jsonData[i]["Name"].toUpperCase().replace("\\", "").replace(":", "");
                    resp += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' value='" + text + "' id='drive" + myJsonLength + "'><label for='drive" + myJsonLength + "'>" + jsonData[i]["Name"].toUpperCase() + "</label><br>";
                    myJsonLength++;
                }
            }
            $('.loadDrivesMassa').html(resp);
            prepare();
        }
    };
    xhttp.open("GET", "a010101110011010110011011" + encodeURI("getDrives").replace(":", "c001100900345711010n") + ".1j1s1o1n1", true);
    xhttp.send();
}*/
function prepare() {
    constitutedString = "";
    for (var i = 0; i < myJsonLength; i++) {
        var member = document.getElementById('drive' + i);
        member.addEventListener("click", function () {
            var vlue = this.getAttribute("value");
            if (isIn(vlue, constitutedString)) {
                constitutedString.replace(vlue + ";", "");
            }
            else {
                constitutedString += vlue + ";";
            }
        });

    }
}

function isIn(small, big) {
    var result = false;
    var array = big.split(";");
    for (var i = 0; i < array.length; i++) {
        if (array[i] == small) {
            result = true;
            break;
        }
    }
    return result;
}

function sendFinal() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var Data = this.responseText;
            alert(Data);
        }
    };
    xhttp.open("GET", "a010101110011010110011011" + encodeURI("getDrives").replace(":", "c001100900345711010n") + ".1m1u1s1i1c1s1", true);
    xhttp.send();
}

function reconstitute(path, constraint) {
    var splitnonesense = path.split(constraint);
    var reconstitutedString = "";
    for (var i = 0; i < splitnonesense.length; i++) {
        // if(i!=splitnonesense.length-1)
        reconstitutedString += path.replace(constraint, "\'");
    }
    console.log("reconstitutedString: " + reconstitutedString);
    return reconstitutedString;
}

function mkdirNow(path, folderName) {
    //path=reconstitute(path,"ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645");
    //$('.showme').text('');
    var name = "0001200oieuahdjsbco13846t9eqd7gvizcm1o2371" + folderName.replace("\\", "").replace("/", "").replace("<", "").replace(">", "").replace("\"", "").replace("\'", "").replace(":", "").replace("?", "").replace("*", "").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'") + workingExt;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (this.responseText == "true") {
                Materialize.toast('Create Successful', 3000, 'rounded');
                load(current);
            }
            else
                Materialize.toast('Create Unsuccessful', 3000, 'rounded');
            //  alert(this.responseText);

        }
    };

    xhttp.open("GET", "/a010101110011010110011011" + encodeURI(path).replace(":", "c001100900345711010n") + name + ".1c1r1e1a1t1e1", true);
    xhttp.send();
    $('#mkdir').val('');
    $('#mkdirlabel').val('');
    $('#mkdirmodal').modal('close');
}

function mediaClick(url, type, mediaType, event) {
    emptyholder();
    url = url.replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'");
    console.log(url);
    if (event.button == 2) {
        var split = url.split('\\');
        var rename = split[split.length - 1].replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'").replace("ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645", "\'");

        if (type == 1) {
            $('.open').text("Open");
            $('.mkdir').show(0);
            $('.open').attr('type', 1);
            $('#rename').val(rename);
            workingExt = "";
        }
        else {
            $('.open').text("Download");
            $('.mkdir').hide(0);
            $('.open').attr('type', 2);
            var renamesplit = rename.split('.');
            var actualrename = "";
            for (var i = 0; i < renamesplit.length - 1; i++) {
                actualrename += renamesplit[i];
                if (i != renamesplit.length - 2) {
                    actualrename += ".";
                }
            }
            $('#rename').val(actualrename);
            workingExt = "." + renamesplit[renamesplit.length - 1];
        }


        $('.open').attr('path', url);


        if ((event.pageY + $(".menu").height()) > $(window).height()) {
            $('.menu').css('top', event.pageY - 6 - $('.menu').height());
        }
        else {
            $('.menu').css('top', event.pageY + 6);
        }

        if ((event.pageX + $(".menu").width()) > $(window).width()) {
            $('.menu').css('left', event.pageX - 6 - $('.menu').width());
        }
        else {
            $('.menu').css('left', event.pageX + 6);
        }
        $('.menu').show();
    }
    else {
        if (type == 2) {
            if (mediaType == 1) {

                $('.imageViewer').attr('src', encrypt(url));

                $('#imageViewer').modal('open');
            }
            if (mediaType == 2) {
                $('#audioPlayer').attr('src', encrypt(url));
                $('#audio').attr('src', encrypt(url));
                console.log(encrypt(url));
                $('#audio').load();
                Materialize.toast('Audio loading.. !', 2000, 'rounded', function () {
                    $('.audiodiv').slideDown(300, function () {
                        Materialize.toast('Audio loaded.. !', 2000, 'rounded');
                    });
                });

            }
            if (mediaType == 3) {

                $('#videoPlayer').attr('src', encrypt(url));
                console.log(encrypt(url));
                $('#video').load();
                $('.videodiv').fadeIn(300, function () {
                    Materialize.toast('Video loaded.. !', 2000, 'rounded');
                    Materialize.toast('Double Click Video to close.. !', 2000, 'rounded');
                });


            }
        }

    }
}

function encrypt(url) {
    return "/a010101110011010110011011" + url;
}

function pauseVid() {
    $('#videoPlayer').attr('src', '');
    $('.videodiv').slideUp(300, function () {
        $('#video').load();
        Materialize.toast('Video Stopped', 3000, 'rounded');
    });


}

function pauseAud() {
    //$('#audioPlayer').attr('src','');
    //$('.audiodiv').slideUp(300,function(){
    //    $('#audio').load();
    //    Materialize.toast('Audio Stopped',1000,'rounded');
    //});
    alert("sjkasd");

}


function backButtonClicked(ctx, event) {
    var path = ctx.getAttribute('path');
    // path=path.replace("%","2163e87sabdiaduahbd7863t4e817tgebdhjaczz").replace("\\\\","/").replace("\'","ee903467tghjadeqew143tafgcnomanvuyd65622335110001191928752645").replace("#","243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30");
    path = encr(path);
    folderClick(path, 1, event);
}

function fileDown(ctx, event) {  //click of a file ...
    var path = ctx.getAttribute('path');
    if (event.ctrlKey) {                 // pressing the control key while clicking .... :)
        path = encr(path);
        if ($(ctx).hasClass('highlightedctrl')) {
            $(ctx).removeClass('highlightedctrl');
            removeFromList(path);
        }
        else {
            $(ctx).addClass('highlightedctrl');
            addToList(path);
        }
    }
    else {
        folderClick(encr(path), 2, event);
    }
}

function mediaDown(ctx, event) {  //click of a file...
    var path = ctx.getAttribute('path');
    var mediaType = ctx.getAttribute('media');
    if (event.ctrlKey) {                 // pressing the control key while clicking .... :)
        path = encr(path);
        if ($(ctx).hasClass('highlightedctrl')) {
            $(ctx).removeClass('highlightedctrl');
            removeFromList(path);
        }
        else {
            $(ctx).addClass('highlightedctrl');
            addToList(path);
        }
    }
    else {
        mediaClick(mediaencr(encr(path)), 2, mediaType, event);
    }
}

function encr(repath) {
        return repath.split("%").join("2163e87sabdiaduahbd7863t4e817tgebdhjaczz").split("#").join("243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30")
     .split("\\\\").join("/");
}

function decr(repath) {
  return repath.split("2163e87sabdiaduahbd7863t4e817tgebdhjaczz").join("%")
        .split("243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30").join("#");
}

function mediaencr(repath) {
    var path = repath;
    for (var i = 0; i <= path.split("[").length; i++) {
        path = path.replace("[", "15263eswysadjkfg3i16754r1623g4hved315634e131256tevjhzsc");
    }
    for (var i = 0; i <= path.split("]").length; i++) {
        path = path.replace("]", "2135r67134gbjnsaci317648r123ed7gvbcnm612qygrzcjqkh3rt37");
    }
    return path;
}


/* Get props method to get properties of the file/folder/media */

function getProps(filepath) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            $('#props').html(this.responseText);
        }
    };

    xhttp.open("GET", "/a010101110011010110011011" + removehashtag(encodeURI(filepath)).replace(":", "c001100900345711010n") + ".1p1r1o1p1e1r1t1i1e1s1", true);
    xhttp.send();
}


//Delete selected files (using the ctrl click)


function deleteSelectedFiles() {
    $('.delnotification').show(300);
    var elts = getEltList().split("|");
    var text = "";
    for (var counter = 0; counter < elts.length; counter++) {
        $('.indicator').text('deleting ' + elts[counter]);
        deletefile(elts[counter]);
    }
    emptyholder();

    /*below is commented out because its changed from an 'all at once delete' to 'one at a time' delete*/


    //var xhttp = new XMLHttpRequest();
    //xhttp.onreadystatechange = function () {
    //    if (this.readyState == 4 && this.status == 200) {
    //        $('#props').html(this.responseText);
    //    }
    //};
    //
    //xhttp.open("GET", "/a010101110011010110011011" + removehashtag(encodeURI(holder)).replace(":", "c001100900345711010n") + ".2d2e2l2e2t2e2", true);
    //xhttp.send();
}

function replaceSingleSlashWithDoubleAntiSlash(text) {
    var resp = text;
    for (var i = 0; i < text.split("/").length; i++) {
        resp = resp.replace("/", "\\\\");
    }
    return resp;
}

function confirmDelete() { //confirm delete of multiple elemnts(ctrl)
   if(readWrite){if ($('.delete').hasClass('clickableOption')) {
        $('.confirmMultipleDeleteBody').html("<center>" +
            "<div class='circle turn' style='border:5px solid transparent;border-left: 5px solid #1a237e; width: 50px;height:50px;'>" +
            "</div></center>");
        var elts = getEltList().split("|");
        var text = "<h6>Sure you want to delete the following?? (Click to remove from selected items to delete)</h6><div class='collection'>";
        for (var counter = 0; counter < elts.length; counter++) {
            text += "<a class='collection-item' href='#!' " +
                "onclick=\'remove(this);' path=\"" + encr(elts[counter]) + "\">" + decr(elts[counter]) + "<span class='new badge pulse btn'>Remove</span></a>"
        }
        text += "</div>";
        $('.confirmMultipleDeleteBody').html(text);
        $('#confirmMultipleDeleteModal').modal('open');
    }}
    else{
       Materialize.toast('Access Denied for read/write',3000);
   }

}

//remove(this);

function remove(ctx) {
    var path = $(ctx).attr('path');
    removeFromList(path);
    //$(ctx).fadeOut(360);
    console.log('im in');
    var elt = document.getElementsByTagName('tr');
    console.log(replaceSingleSlashWithDoubleAntiSlash(path));
    for (var i = 0; i < elt.length; i++) {
        if (elt[i].getAttribute('path') == replaceSingleSlashWithDoubleAntiSlash(path)) {
            $(elt[i]).removeClass('highlightedctrl');
            $('.indicator').text('Element removed');
        }
    }
    if (getEltNumber() == 0) {
        $('#confirmMultipleDeleteModal').modal('close');
        Materialize.toast('All cleared', 3000, 'rounded');
        $('.indicator').text('All selected, removed');
    }
}

/* Clipboard management (multiple copy/cut)    */
var copiedFiles = ""; //copied files will get the total value of holder whenever copy is clicked
var cutFiles = ""; //cut files will get the total value of holder whenever cut is clicked
function copyClicked(ctx) {   //click of copy on the options menu
   if(readWrite){ if ($(ctx).hasClass('clickableOption')) {
        var numero = getEltNumber();
        copiedFiles = holder;
        $('.clipboardValue').text(getEltNumber());
        cutFiles = "";
        emptyholder();
        console.log('copy clicked');
        Materialize.toast('Copied ' + numero + ' files', 3000, 'rounded');
        activatePaste();
    }
    else {
        Materialize.toast('No files selected', 3000, 'rounded');
    }
   }
   else{
       Materialize.toast('Access Denied for read/write',3000);
   }
}

function cutClicked(ctx) { //click of cut on the options menu
   if(readWrite){ if ($(ctx).hasClass('clickableOption')) {
        var numero = getEltNumber();
        cutFiles = holder;
        $('.clipboardValue').text(getEltNumber());
        copiedFiles = "";
        emptyholder();
        console.log('cut clicked');
        Materialize.toast('Cut ' + numero + ' files', 3000, 'rounded');
        activatePaste();
    }
    else {
        Materialize.toast('No files selected', 3000, 'rounded');
    }}
    else{
       Materialize.toast('Access Denied for read/write',3000);
   }
}

function activatePaste() {
    var pasteref = $('.paste');
    pasteref.removeClass('unclickableOption');
    pasteref.addClass('clickableOption');
}

function deactivatePase() {
    var pasteref = $('.paste');
    pasteref.removeClass('clickableOption');
    pasteref.addClass('unclickableOption');
}

function pasteClicked() {
  if(readWrite){ if ($('.paste').hasClass('clickableOption')) {
        $('#pasteconfirmmodal').modal('open');
    }
    else {
        Materialize.toast('Nothing to paste', 3000, 'rounded');
    }}
    else{
      Materialize.toast('Access Denied for read/write',3000);
  }
}

var operationType = 'sk'; //operationType will indicate the type of paste operation that is if overwrite or skip ; default is skip

function actualPaste() {
    var currentDir = current;
    var operation; //indicates whether its a copy or paste operation;
    var data; //indicates the data to be copied or cut
    if (copiedFiles !== "") {
        operation = "copyop";
        data = copiedFiles;

    }
    else {
        operation = "cutop";
        data = cutFiles;
    }

// pasting one by one
//     give data to holder since holder already has predeined methods but give/take it silently(not by calling methods)
    holder = data;
    var elts = getEltList().split("|");
    var text = "";
    $('.pastenotification').show(300);
    for (var counter = 0; counter < elts.length; counter++) {
        toast("pasting ... " + elts[counter], 3000);
        paste(elts[counter], currentDir, operation);
    }
    holder = "";
    $('.clipboardValue').text(0);
    copiedFiles = "";
    cutFiles = "";
    deactivatePase();
}

function paste(aFile, currentDir, operation) {
    const SEPARATOR = "3165qgus091384tw7017qhdcmsloadutiy";
    /*  SEQUENCE : operation + SEPERATOR + operationType + SEPARATOR + data (eachFileInThedata) + SEPARATOR + current  */
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            if (this.responseText === "") {
                toastMe(aFile + "Pasted successfully");
                load(current, 1);
            }
            else {
                toast(+aFile + " :: " + this.responseText, 2000);
            }
            $('.pastenotification').hide(300);
        }
    }
    xhttp.open("GET", "a010101110011010110011011" + encodeURI(removehashtag(operation + SEPARATOR + operationType + SEPARATOR + aFile + SEPARATOR + currentDir)).replace(":", "c001100900345711010n") + ".1p1a1s1t1e1", true);
    xhttp.send();
    console.log("pasting :" + aFile);

}

function emptyClipboard() {
    if (copiedFiles !== "" || cutFiles !== "") {
        $('.clipboardValue').text(0);
        copiedFiles = "";
        cutFiles = "";
        deactivatePase();
        toastMe('All cleared');
    }
    else {
        toastMe('Clipboard Already Empty');
    }
}

function toastMe(text) {  //a simple methode for a toast creator
    Materialize.toast(text, 3000, 'rounded');
}

function toast(text, time) {  //a simple methode for a toast creator
    Materialize.toast(text, time, 'rounded');
}


// This is the function to refresh drives
//Originally it was made in such a way that it requests automatically but since there is interference with the load of folders.It was moved

function refreshDrives() {                //Drive manager... checks drive insertion/removal

    //$('.indicator').text('Searching for changes...');

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        console.log("old number: " + numberOfDrives);
        if (this.readyState === 4 && this.status === 200) {
            if (parseInt(this.responseText) > numberOfDrives) {
                Materialize.toast('<img src="stuff/icons/HDD_24px_1.png"> <span>&nbsp;&nbsp;New Drive(s) Detected</span>', 2000);
                if ((parseInt(this.responseText) - numberOfDrives) > 1) {

                    setTimeout(function () {
                        $('.indicator').text((parseInt(this.responseText) - numberOfDrives) + ' New Drives detected...');
                    }, 10);
                }
                else {
                    setTimeout(function () {
                        $('.indicator').text('New Drive detected...');
                    }, 10);
                }


            }
            else if (parseInt(this.responseText) < numberOfDrives) {
                Materialize.toast('<img src="stuff/icons/HDD_24px_1.png"><span>&nbsp;&nbsp;Drive(s) Removed</span>', 2000);
                //  console.log('Remove '+(numberOfDrives - parseInt(this.responseText))+' Drive');
                if ((numberOfDrives - parseInt(this.responseText)) > 1) {
                    setTimeout(function () {
                        $('.indicator').text((numberOfDrives - parseInt(this.responseText)) + ' Drives have been removed');
                    }, 10);
                } else {
                    setTimeout(function () {
                        $('.indicator').text('A Drive has been Removed');
                    }, 10);
                }


            }
            else {
                setTimeout(function () {
                    $('.indicator').text('No new Drive detected');
                }, 10);
                Materialize.toast('<img src="stuff/icons/HDD_24px_1.png"> <span>&nbsp;&nbsp;No New Drive Detected</span>', 2000);
                // setTimeout(function(){$('.indicator').text('No new Drive detected')},1000);
            }
            loadDoc();
            /* in any case, we must load Doc again so that the changes are done after every second... remember in loadDoc()
                               * That  the content of .me is only refreshed when previousresp != resp;
                               */
            $('.spinner').removeClass('spinner');
        }
    };
    xhttp.open("GET", "a010101110011010110011011" + encodeURI("checkDrives").replace(":", "c001100900345711010n") + ".1c1h1e1c1k1", true);
    xhttp.send();
}
var mass_download_url;
function download() {
    if ($('.download').hasClass('clickableOption')) {
        $('.downloadModalMain').html('<center><div class=\'circle turn\' style=\'border:5px solid transparent;border-left: 5px solid #1a237e; width: 100px;height:100px;\'></div></center>');
        $('#downloadModal').modal('open');
        var elts = getEltList().split("|").join("oi3wnscnkjznciuyasdhbhzvxvgihwhssnjanxbbvfsghgsakkannshhyauhgshbbcbvafrwyq");
        console.log(elts);
        $.ajax({
            url: '/a010101110011010110011011ze.1f1i1l1e1s1',
            type: "POST",
            data: elts,
            dataType: 'text',
            async: true,
            success: function (data) {
                var separatorMan ="1234dscscsscscsdf792tgdfvsadcv13e765drfytcvahzcpdafd";
                //mass_download_url=data.split(separatorMan)[0];
               $('.downloadModalMain').html('<h5>Response from server </h5><h6>'+data+'</h6>');
                $('#dmf').show();
            },
            error: function (data){
                $('.downloadModalMain').html('<h5>An error occurred </h5><h6>'+data+'</h6>');
                $('#dmf').show();
            }
        });
        emptyholder();
    }
}
function downloadInit(){
    var downloadPath = '/FileServerDownload.zip'
    ;//mass_download_url;
    var anchor = document.createElement('a');
    anchor.href = downloadPath;
    anchor.download = url;
    anchor.target = '_blank';
    anchor.click();
}

function validatePass(event,ctx){
    var passInput = $(ctx);
    if(event.keyCode === 13){
    if(passInput.val()!==""){
        if(passInput.val()=== password){
            $('.loader').fadeOut(360);
        }
        else{
            alert("Sorry, try again!");
        }
    }
    else{
        alert("Sorry, try again!");
    }
    }
}
var password;
function checkAuthAccess(){
    $.ajax({
        url : 'userAuth.1u1s1e1r1a1u1t1h1',
        type : 'POST',
        success : function(resp){
            if(resp !=="1f2a3l4s5e6lasdbaj901289wshadakjbalaksdnki"){
                console.log(resp);
                password = resp;
                $('#loading').fadeOut(360,function(){
                    $('#passfield').fadeIn(360);
                });
            }
            else{
                $('.loader').fadeOut(360);
            }
        },
        error : function(xhr,p1,p2){

        }
    });
}
var readWrite = false;
function rwA(){ // checks r/w access;
    $.ajax({
        url : 'rwA.1r1w1a1r1w1a',
        type : 'POST',
        success : function(resp){
            readWrite = resp === "true";
        },
        error : function(xhr,p1,p2){

        }
    });
}