function validColumns(floor, x, y) {
  if (y === 0) {
    return true;
  } else if (floor[0][x][y - 1]) {
    return true
  } else if (x > 0 && floor[1][x - 1][y]) {
    return true;
  } else if (floor[1][x][y]) {
    return true;
  }
  return false;
}

function validBeams(floor, n, x, y) {
  if (floor[0][x][y - 1]) {
    return true;
  } else if (x < n && floor[0][x + 1][y - 1]) {
    return true;
  } else if (x > 0 && x < n && floor[1][x - 1][y] && floor[1][x + 1][y]) {
    return true;
  }

  return false;
}

function removeColumns(floor, n, x, y) {
  floor[0][x][y] = false;
  if (y < n && floor[0][x][y + 1] && !validColumns(floor, x, y + 1)) {
    floor[0][x][y] = true;
  } else if (y < n && floor[1][x][y + 1] && !validBeams(floor, n, x, y + 1)) {
    floor[0][x][y] = true;
  } else if (x > 0 && floor[1][x - 1][y + 1] && !validBeams(floor, n, x - 1, y + 1)) {
    floor[0][x][y] = true;
  }
}

function removeBeams(floor, n, x, y) {
  floor[1][x][y] = false;
  if (floor[0][x][y] && !validColumns(floor, x, y)) {
    floor[1][x][y] = true;
  } else if (x < n && floor[0][x + 1][y] && !validColumns(floor, x + 1, y)) {
    floor[1][x][y] = true;
  } else if (x > 0 && x < n && floor[1][x - 1][y] && floor[1][x + 1][y]) {
    if (!validBeams(floor, n, x - 1, y) || !validBeams(floor, n, x + 1, y)) {
      floor[1][x][y] = true;
    }
  } else if (x < n && floor[1][x + 1][y] && !validBeams(floor, n, x + 1, y)) {
    floor[1][x][y] = true;
  } else if (x > 0 && floor[1][x - 1][y] && !validBeams(floor, n, x - 1, y)) {
    floor[1][x][y] = true;
  }
}



function solution(n, build_frame) {
  const answer = [];
  const floor = new Array(2).fill(0).map(v => new Array(n + 1));
  for (let i = 0; i <= n; i++) {
    floor[0][i] = new Array(n + 1);
    floor[1][i] = new Array(n + 1);
  }

  for (let i = 0; i < build_frame.length; i++) {
    const [x, y, a, b] = build_frame[i];
    if (b === 1) {
      if (a === 0) {
        if (validColumns(floor, x, y)) {
          floor[0][x][y] = true;
        }
      } else {
        if (validBeams(floor, n, x, y)) {
          floor[1][x][y] = true;
        }
      }
    } else {
      if (a === 0) {
        removeColumns(floor, n, x, y);
      } else {
        removeBeams(floor, n, x, y);
      }
    }
  }

  for (let i = 0; i < 2; i++) {
    for (let x = 0; x <= n; x++) {
      for (let y = 0; y <= n; y++) {
        if (floor[i][x][y]) {
          answer.push([x, y, i]);
        }
      }
    }
  }

  answer.sort((a, b) => {
    if (a[0] === b[0]) {
      if (a[1] === b[1]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    }
    return a[0] - b[0];
  })

  return answer;
}

console.log(solution(5, [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1], [2, 0, 0, 0], [1, 1, 1, 0], [2, 2, 0, 1]]));