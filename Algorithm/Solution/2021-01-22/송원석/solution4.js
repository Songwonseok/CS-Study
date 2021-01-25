function findRoot(tree) {
  for (let idx = 1; idx < tree.length; idx++) {
    if (tree[idx].parent === idx)
      return tree[idx];
  }
}

function getSkillPoint(skill) {
  if (skill.child.length === 0) {
    skill.sp = 1;
    return skill.sp;
  }

  let mySP = 0;
  for (let i = 0; i < skill.child.length; i++) {
    mySP += getSkillPoint(skill.child[i]);
  }

  skill.sp = mySP;
  return skill.sp;
}

function solution(total_sp, skills) {
  const tree = new Array(skills.length + 2).fill(0).map((el, idx) => {
    return {
      parent: idx,
      child: [],
      sp: 0
    }
  });

  skills.forEach(el => {
    tree[el[1]].parent = tree[el[0]];
    tree[el[0]].child.push(tree[el[1]]);
  });

  const root = findRoot(tree);
  getSkillPoint(root);

  const spCount = tree.reduce((acc, skill) => {
    return acc += skill.sp;
  }, 0)

  const answer = [];
  const spPerCount = total_sp / spCount;

  for (let i = 1; i < tree.length; i++) {
    answer.push(tree[i].sp * spPerCount);
  }

  return answer;
}