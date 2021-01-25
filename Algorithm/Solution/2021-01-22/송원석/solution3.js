function solution(card) {
  const set = new Set();
  card.forEach(el => {
    if (set.has(el)) {
      set.delete(el);
    } else {
      set.add(el);
    }
  })
  return [...set].sort((a, b) => a - b);
}