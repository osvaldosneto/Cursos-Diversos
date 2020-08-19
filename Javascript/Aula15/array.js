let num = [5, 8, 3, 9, 'vinte']
//console.log(num[0])
num.push("carro")

/*for(var i=0; i<num.length; i++){
    console.log(num[i])
}

num.sort()
for(var i=0; i<num.length; i++){
    console.log(num[i])
}*/

for(var aux in num){
    console.log(num[aux])
}

console.log(num.indexOf(8))