function solution(n, lost, reserve) {
  // 모든 학생이 체육복을 가지고 있다고 가정.
  let students = Array(n).fill(1);

  // 도난당한 학생 체크.
  for (let i = 0; i < lost.length; i++) {
    students[lost[i] - 1]--;
  }

  // 여벌 체육복을 가진 학생 체크.
  for (let i = 0; i < reserve.length; i++) {
    students[reserve[i] - 1]++;
  }

  // 전체 학생 중 앞 뒤에 학생한테 빌려줄 수 있으면 빌려주기.
  for (let i = 0; i < n; i++) {
    if (students[i] === 0 && students[i - 1] === 2) {
      students[i]++;
      students[i - 1]--;
    } else if (students[i] === 0 && students[i + 1] === 2) {
      students[i]++;
      students[i + 1]--;
    }
  }

  // 체육수업을 들을 수 있는 학생의 수를 반환.
  let count = 0;
  for (let i = 0; i < n; i++) {
    if (students[i] > 0) {
      count++;
    }
  }

  return count;
}