const cube = document.querySelector('.cube');
const shadow = document.querySelector('.shadow');

const spin = 360;
const turn = 90;
const delay = 1;

gsap.timeline({ repeat: -1, defaults: { ease: 'power2.inOut', delay}})
    .to(cube, { rotateX: `+=${(spin * -1) - turn}` })
    .to([cube, shadow], {rotate: `+=${(spin * 4) + (turn * 2) }` })
    .to(cube, {rotateY: `+=${(spin * 1) + (turn * 2) }`})
    .to([cube, shadow], {rotate: `+=${(spin * -6) - (turn * 2) }` })
    .to(cube, { rotateX: `+=${(spin * -2) - turn }`})
    .to([cube, shadow], { rotate: `+=${(spin * 5) + (turn * 2) }` });