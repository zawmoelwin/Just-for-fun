var key = { 0 : 0, 1 :1 }

function fib2(n){
  if (key.hasOwnProperty(n)){
    return key[n];
  }else{
    console.log(n);
    key[n] = fib2(n-1) + fib2 (n-2)
    return key[n];
  }
}
