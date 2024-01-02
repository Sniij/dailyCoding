class PriorityQueue {

    constructor() {
        this.queue = [];
    }

    getLeftChild(parent) { return 2 * parent + 1; }
    getRightChild(parent) { return 2 * parent + 2; }
    getParent(child) { return Math.floor((child - 1) / 2); }

    // 새로운 key 삽입
    add(key) {
        this.queue.push(key);
        var idx = this.queue.length - 1;
        
        // 새로운 key 에 대해 parent key 가 더 작을 때까지 반복해서 idx 변경
        while (idx !== 0 && this.queue[this.getParent(idx)] > this.queue[idx]) {
            this.swap(idx, this.getParent(idx));
            idx = this.getParent(idx);
        }

    }

    // 상위 key (제일 작은 놈) 제거하고 반환
    poll() {
        const len = this.queue.length;
        const root = this.queue[0];

        if (len <= 0) 
            return 0;
        if (len === 1) 
            this.queue = [];
        // 마지막 key 를 루트로 올려놓고 재정렬 필요
        else {
            this.queue[0] = this.queue[len - 1];
            this.queue.length = len - 1;
            this.offer(0);
        }


        return root;
    }

    // Queue 정렬 메서드
    offer(idx) {
        const left = this.getLeftChild(idx);
        const right = this.getRightChild(idx);
        var smallest = idx;
        
        // 왼쪽 자식 O + 왼쪽 자식이 입력받은 idx 보다 더 작으면 작은 놈은 왼쪽 자식임
        if (left < this.queue.length && this.queue[smallest] > this.queue[left]) 
            smallest = left;
        // 오른쪽 자식 O + 오른쪽 자식이 입력받은 idx 보다 더 작으면 작은 놈은 오른쪽 자식임
        if (right < this.queue.length && this.queue[smallest] > this.queue[right]) 
            smallest = right;
        // 만약 위에서 작은 놈을 재정의 했으면 다시 정렬이 필요함
        if (smallest !== idx) {
            this.swap(smallest, idx);
            this.offer(smallest);
        }
    }

    swap(i, j) {
        var tmp = this.queue[i];
        this.queue[i] = this.queue[j];
        this.queue[j] = tmp;
    }
}

function solution(scoville, K) {
    var answer = 0;

    const queue = new PriorityQueue();

    scoville.forEach(el => queue.add(el));

    while (queue.queue[0] < K) {
        if(queue.queue.length == 1) return -1;
        const a = queue.poll();
        const b = queue.poll();
        queue.add(a + b * 2);
        answer++;
    }


    return answer;
}