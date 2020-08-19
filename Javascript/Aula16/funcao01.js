function parimpar(n){
    if(n%2 == 0){
        return "par"
    } else {
        return "ímpar"
    }
}

function fatorial(n){
    let fat = 1
    for(var i=1; i<n+1; i++){
        fat = fat * i
    }
    return fat
}

console.log(parimpar(5))
console.log(parimpar(4))

for(var i=0; i < 10; i++){
    console.log(parimpar(i))
}

console.log(fatorial(6))