class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 붕대 감기
        // 붕대 감기를 사용하면 t초 동안 붕대를 감으며 매초마다 x만큼의 체력을 회복
        // t초 연속으로 붕대를 감으면 y만큼의 체력 추가 회복(붕대 감기를 끝까지 하게 되면 추가 회복)
        // 붕대 감기를 시전하는 동안 공격을 당하면 즉시 취소됨.
        // 공격이 끝나거나, 기술 시전이 끝나면 즉시 재시전 가능 (연속 시전(추가 회복을 위한) 게이지는 0으로 초기화)
        // 공격은 절대량으로 받아 햔재 체력이 줄어들고, 체력이 0이하가 되면 캐릭터는 죽음.
        
        // 붕대감기 정보[시전시간, 초당회복량, 추가회복량], 
        // 캐릭터가 가진 최대 체력, 
        // 몬스터의 공격패턴[N][공격시간, 피해량] (공격패턴은 공격시간을 기준으로 오름차순 정렬상태) 이 주어질 때
        // 캐릭터가 끝까지 생존할 수 있는 지의 여부를 판단 (모든 공격패턴이 끝난 후 남은 체력을 return)        
        
        int maxHealth = health;
        int bandageGauge = 0;
        int lastTime = attacks[attacks.length-1][0];
        int attackInd = 0;
        for(int i = 1; i <= lastTime; i++){
            int attackTime = attacks[attackInd][0];
            
            // 공격받지 않고 있을 때
            if(i != attackTime){
                bandageGauge++;
                health += bandage[1];

                if(bandageGauge == bandage[0]){
                    bandageGauge = 0;
                    health += bandage[2];
                }
                if(health > maxHealth) health = maxHealth;
                

            }else{ // 공격타임
                bandageGauge = 0;
                health -= attacks[attackInd++][1];
            }
            if(health <= 0) return -1;
        }
        
        return health;

    }
}