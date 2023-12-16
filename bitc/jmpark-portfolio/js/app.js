const content = '안녕하세요. 박정민 포트폴리오입니다.';
const text = document.querySelector('.typer-text');
let i = 0;

function typing() {
    if (i < content.length) {
        let txt = content.charAt(i);
        text.innerHTML += txt;
        i++;
    }
}
setInterval(typing, 200);

$('.bar_open').on('click', function () {
    if ($(this).hasClass('bar_open') === true) {
        $(this).attr('class', 'bar_close');
        $('.bar_menu').removeClass('hide');
    } else {
        $(this).attr('class', 'bar_open');
        $('.bar_menu').addClass('hide');
    }
});

$(document).ready(function ($) {
    $('.bar_li').on('click', function (e) {
        e.preventDefault();
        $('html,body').animate({ scrollTop: $(this.hash).offset().top }, 500);
    });
});
