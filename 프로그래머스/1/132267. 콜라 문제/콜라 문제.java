class Solution {
    public int solution(int a, int b, int n) {
        
        // 빈 병 a개를 갖다주면 b개의 새 제품을 준다.
        // n개를 갖다주면 몇 병을 받을 수 있나?
        int answer = 0;
        int currentBottle = n;
        
        // 새 제품으로 교환
        // 교환 후 남은 빈 병 수
        // 총 받은 제품 수 업데이트
        // 현재 가진 병 수 업데이트 (새 제품 + 남은 빈 병)
        
        while(currentBottle >= a){
            
            int newProduct = (currentBottle/a) * b;
            int emptyBottle = currentBottle%a;
            answer += newProduct;
            currentBottle = newProduct + emptyBottle;
            
        }
        
        return answer;
    }
}