function makeComb(menus, visit) {
  let comb = "";
  for (let i = 0; i < visit.length; i++) {
    if (visit[i]) {
      comb += menus[i];
    }
  }
  return comb;
}

function dfs(menus, size, depth, start, visit, courseMenuMap) {
  if (depth === size) {
    const comb = makeComb(menus, visit);
    if (courseMenuMap.has(comb)) {
      courseMenuMap.set(comb, courseMenuMap.get(comb) + 1);
    } else {
      courseMenuMap.set(comb, 1);
    }
    return;
  }

  for (let i = start; i < visit.length; i++) {
    if (!visit[i]) {
      visit[i] = true;
      dfs(menus, size, depth + 1, i, visit, courseMenuMap)
      visit[i] = false;
    }
  }
}

function solution(orders, course) {
  const answer = [];
  const courseMenuMap = new Map();

  for (let i = 0; i < course.length; i++) {
    for (let j = 0; j < orders.length; j++) {
      const menus = orders[j].split("").sort();
      const visit = new Array(orders[j].length).fill(false);
      dfs(menus, course[i], 0, 0, visit, courseMenuMap);
    }
  }
  const courseList = [...courseMenuMap].filter(v => v[1] >= 2);
  courseList.sort((a, b) => {
    if (a[0].length === b[0].length) {
      return b[1] - a[1];
    }
    return a[0].length - b[0].length
  })

  for (let i = 0; i < course.length; i++) {
    let max = 0;
    for (let j = 0; j < courseList.length; j++) {
      if (course[i] === courseList[j][0].length) {
        if (max <= courseList[j][1]) {
          max = courseList[j][1];
          answer.push(courseList[j][0]);
        } else {
          break;
        }
      }
    }
  }

  answer.sort();
  return answer;
}

console.log(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]));