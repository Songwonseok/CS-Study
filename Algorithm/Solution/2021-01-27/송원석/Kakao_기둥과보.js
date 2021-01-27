function validColumns(floor, x, y) {
  if (y === 0) { // 바닥인 경우
    return true;
  } else if (floor[0][x][y - 1]) { // 밑에 기둥이 있는 경우
    return true
  } else if (x > 0 && floor[1][x - 1][y]) { // 왼쪽에 보가 있는 경우
    return true;
  } else if (floor[1][x][y]) { // 보 위에 있는 경우
    return true;
  }
  return false;
}

function validBeams(floor, n, x, y) {
  if (floor[0][x][y - 1]) { // 기둥 위에 있는 경우
    return true;
  } else if (x < n && floor[0][x + 1][y - 1]) { // 우측 아래 기둥이 있는 경우
    return true;
  } else if (x > 0 && x < n && floor[1][x - 1][y] && floor[1][x + 1][y]) { // 양 옆에 보가 있는 경우
    return true;
  }

  return false;
}

function removeColumns(floor, n, x, y) {
  floor[0][x][y] = false; // 일단 기둥을 제거하고 주변 구조물 유효성 검사
  if (y < n && floor[0][x][y + 1] && !validColumns(floor, x, y + 1)) { // 위에 기둥이 있는 경우
    floor[0][x][y] = true;
  } else if (y < n && floor[1][x][y + 1] && !validBeams(floor, n, x, y + 1)) { // 위에 보가 있는 경우
    floor[0][x][y] = true;
  } else if (x > 0 && floor[1][x - 1][y + 1] && !validBeams(floor, n, x - 1, y + 1)) { // 좌측 위에 보가 있는 경우
    floor[0][x][y] = true;
  }
}

function removeBeams(floor, n, x, y) {
  floor[1][x][y] = false; // 일단 보를 제거하고 주변 구조물 유효성 검사
  if (floor[0][x][y] && !validColumns(floor, x, y)) { // 현재 위치에 기둥이 존재하는 경우
    floor[1][x][y] = true;
  } else if (x < n && floor[0][x + 1][y] && !validColumns(floor, x + 1, y)) { // 우측에 기둥이 존재하는 경우
    floor[1][x][y] = true;
  } else if (x > 0 && x < n && floor[1][x - 1][y] && floor[1][x + 1][y]) { // 양 옆에 보가 존재하는 경우
    if (!validBeams(floor, n, x - 1, y) || !validBeams(floor, n, x + 1, y)) { // 둘 중에 하나라도 안되면 true
      floor[1][x][y] = true;
    }
  } else if (x < n && floor[1][x + 1][y] && !validBeams(floor, n, x + 1, y)) { // 우측에만 보가 존재하는 경우
    floor[1][x][y] = true;
  } else if (x > 0 && floor[1][x - 1][y] && !validBeams(floor, n, x - 1, y)) { // 좌측에만 보가 존재하는 경우
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