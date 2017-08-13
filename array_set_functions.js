function intersect_array(nest_arrays){
  return nest_arrays.shift().filter(function(mem) {
    return nest_arrays.every(function(array) {
                return array.indexOf(mem) !== -1;
    });
  })
};

function union_arrays (x, y) {
  var obj = {};
  for (var i = x.length-1; i >= 0; -- i)
     obj[x[i]] = x[i];
  for (var i = y.length-1; i >= 0; -- i)
     obj[y[i]] = y[i];
  var res = []
  
  console.log("the whole object", Object.values(obj));
  for (var k in obj) {
    console.log("K in the for loop",k);
    if (obj.hasOwnProperty(k))  // <-- optional
      console.log(obj[k]);
      res.push(obj[k]);
  }
  return res;
}

function diff_array(x, y){
  return x.filter(function(i){return y.indexOf(i)<0})
}
