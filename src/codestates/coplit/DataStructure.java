package codestates.coplit;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class DataStructure {
    public static void main(String[] args){
        QueuePrinter queuePrinter = new QueuePrinter();
        System.out.println( QueuePrinter.queuePrinter(2,10,new int[]{7, 4, 5, 6}));
    }


}

/**
 * 1. Stack 구현
 *  Stack 구현을 위한 기본적인 코드가 작성되어 있습니다. Stack 자료구조의 특성을 이해하고 FILL_ME_IN을 채워 테스트를 통과해 주세요.
 * push(): 스택에 데이터를 추가할 수 있어야 합니다.
 * pop(): 가장 나중에 추가된 데이터를 스택에서 삭제하고 삭제한 데이터를 리턴해야 합니다.
 * size(): 스택에 추가된 데이터의 크기를 리턴해야 합니다.
 * peek(): 가장 나중에 추가된 데이터를 리턴해야 합니다.
 * show(): 현재 스택에 포함되어 있는 모든 데이터를 String 타입으로 변환하여 리턴합니다.
 * clear(): 현재 스택에 포함되어 있는 모든 데이터 삭제합니다.
 * */
class StackImplement {
    private final ArrayList<Integer> listStack = new ArrayList<Integer>();

    // push() : 스택에 데이터 추가
    public void push(Integer data) {
        listStack.add(data);
    }

    // remove() : 스택에 들어있는 argument 값을 삭제 (return 값 x)
    public void remove(Integer data){
        if(!listStack.isEmpty()) listStack.remove(data);
    } // 인덱스를 argument로 주면 해당 인덱스 데이터가 return됨.

    // pop() : 스택에서 맨 마지막 데이터(맨 위에 쌓인 데이터) 삭제 후 해당 데이터 return
    public Integer pop() {
        if(listStack.isEmpty()) return null;
        else return listStack.remove(listStack.size()-1);
    }

    // peek() : 스택에서 맨 마지막 데이터(맨 위에 쌓인 데이터) return
    public Integer peek() {
        if(listStack.isEmpty()) return null;
        else return listStack.get(listStack.size()-1);

    }

    // size() : 스택에 들어있는 데이터 크기 return
    public int size() {
        return listStack.size();
    }

    public void clear() { listStack.clear(); }

    /**
     * 이외
     * empty() : 스택이 비어있는지 boolean 으로 return
     * contains() : 스택에 argument 값이 있는지 boolean 으로 return
     * */

    // show() : 스택에 있는 데이터 출력
    public String show() {
        return listStack.toString();
    }


}

/**
 * 2. Queue 구현을 위한 기본적인 코드가 작성되어 있습니다. Queue 자료구조의 특성을 이해하고 FILL_ME_IN 을 채워 테스트를 통과해주세요.
 * add(): 큐에 데이터를 추가할 수 있어야 합니다.
 * poll(): 가장 먼저 추가된 데이터를 큐에서 삭제하고 삭제한 데이터를 리턴해야 합니다.
 * size(): 큐에 추가된 데이터의 크기를 리턴해야 합니다.
 * peek(): 큐에 가장 먼저 추가된 데이터를 리턴해야 합니다.
 * show(): 큐에 들어있는 모든 데이터를 String 타입으로 변환하여 리턴합니다.
 * clear(): 큐에 들어있는 모든 데이터를 삭제합니다.
 * */
class QueueImplement{
    private final ArrayList<Integer> listQueue = new ArrayList<Integer>();


    // add() : 큐에 데이터를 추가
    public void add(Integer data) {
        listQueue.add(data);
    }

    // remove() : 큐에 들어있는 argument 값을 삭제
    public void remove(Integer data){
        if(!listQueue.isEmpty()) listQueue.remove(data);
    }

    // peek() : 큐에 제일 먼저 들어간 데이터가 return
    public Integer peek() {
        if(listQueue.isEmpty()) return null;
        else return listQueue.get(0);
    }

    // poll() : 큐안에 제일 먼저 들어간 데이터가 삭제되고 해당 데이터를 return
    public Integer poll() {
        if(listQueue.isEmpty()) return null;
        else return listQueue.remove(0);
    }

    // size() : 큐에 들어있는 데이터 크기를 return
    public int size() {
        return listQueue.size();
    }


    public void clear() {
        listQueue.clear();
    }


    public String show() {
        return listQueue.toString();
    }


}

/**
 * 3. Stack 브라우저 뒤로 가기 앞으로 가기
 * 조건
 *  1. 새로운 페이지로 접속할 경우 prev 스택에 원래 있던 페이지를 넣고 next 스택을 비웁니다.
 *  2. 뒤로 가기 버튼을 누를 경우 원래 있던 페이지를 next 스택에 넣고 prev 스택의 top에 있는 페이지로 이동한 뒤 prev 스택의 값을 pop 합니다.
 *  3. 앞으로 가기 버튼을 누를 경우 원래 있던 페이지를 prev 스택에 넣고 next 스택의 top에 있는 페이지로 이동한 뒤 next 스택의 값을 pop 합니다.
 *  4. 브라우저에서 뒤로 가기, 앞으로 가기 버튼이 비활성화일 경우(클릭이 되지 않을 경우)에는 스택에 push 하지 않습니다.
 *  인터넷 브라우저에서 행동한 순서가 들어있는 배열 actions와 시작 페이지 start가 주어질 때 마지막에 접속해 있는 페이지와 방문했던 페이지들이 담긴 스택을 반환하는 솔루션을 만들어 김코딩의 궁금증을 풀어주세요.
 * */
class StackBrowser{
    public ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();

        current.add(start);

        for (String action : actions){
            if(action.equals("-1")){
                if(!prevStack.isEmpty()){
                nextStack.push(current.pop());
                current.push(prevStack.pop());
                }
                else continue;
            } else if (action.equals("1")) {
                if(!nextStack.isEmpty()){
                prevStack.push(current.pop());
                current.push(nextStack.pop());
                }
                else continue;
            } else {
                prevStack.push(current.pop());
                current.push(action);
                nextStack.clear();
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);
        return result;
    }
}

/**
 * 4. Queue 박스 포장
 * 문제
 * 마트에서 장을 보고 박스를 포장하려고 합니다. 박스를 포장하는 데는 폭이 너무 좁습니다. 그렇기에 한 줄로 서 있어야 하고, 들어온 순서대로 한 명씩 나가야 합니다.
 * 불행 중 다행은, 인원에 맞게 포장할 수 있는 기구들이 놓여 있어, 모두가 포장을 할 수 있다는 것입니다. 짐이 많은 사람은 짐이 적은 사람보다 포장하는 시간이 길 수밖에 없습니다.
 * 뒷사람이 포장을 전부 끝냈어도 앞사람이 끝내지 못하면 기다려야 합니다. 앞사람이 포장을 끝내면, 포장을 마친 뒷사람들과 함께 한 번에 나가게 됩니다.
 * 만약, 앞사람의 박스는 5 개고, 뒷사람 1의 박스는 4 개, 뒷사람 2의 박스는 8 개라고 가정했을 때, 뒷사람 1이 제일 먼저 박스 포장을 끝내게 되어도 앞사람 1의 포장이 마칠 때까지 기다렸다가 같이 나가게 됩니다.
 * 이때, 통틀어 최대 몇 명이 한꺼번에 나가는지 알 수 있도록 함수를 구현해 주세요.
 *
 * 인자 1 : boxes
 * int 타입을 요소로 갖는, 포장해야 하는 박스가 담긴 배열
 * 1 ≤ 사람 수 ≤ 10,000
 * 1 ≤ 박스 ≤ 10,000
 *
 * 주의 사항
 * 먼저 포장을 전부 끝낸 사람이 있더라도, 앞사람이 포장을 끝내지 않았다면 나갈 수 없습니다.
 * */
class QueueBox{
    public int paveBox(Integer[] boxes) {
        int cnt = 1;
        int res = 1 ;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(boxes[0]);

        for (int i =1; i<boxes.length; i++){
            if(queue.stream().max(Integer::compare).orElse(1) < boxes[i]) {
                if(res<cnt)
                    res = cnt;
                cnt = 1;
                queue.add(boxes[i]);
            }
            else {
                cnt++;
                queue.add(boxes[i]);
            }
        }
        if (res<cnt)
            res = cnt;
        return res;
    }

}

/**
 * 5. Queue 프린터
 * 김코딩은 최근 인쇄할 일이 많이 생겨 창고에서 안 쓰던 프린터를 꺼냈습니다. 이 프린터의 성능을 테스트하여 새로운 프린터를 장만할지 결정하려고 합니다. 김코딩은 프린터의 인쇄 작업 목록의 크기와 최대 용량을 가정하고 각기 다른 용량의 문서를 차례대로 인쇄하여 모든 문서가 인쇄되는데 최소 몇 초가 걸리는지 테스트하기로 했습니다. 프린터 인쇄 작업 목록의 제한사항은 다음과 같습니다.
 *
 *[제한사항]
 * 인쇄 작업 목록은 칸으로 이루어져 있습니다.
 * 각 칸에는 한 개의 문서만 위치할 수 있습니다.
 * 문서는 1초에 한 칸만 이동할 수 있습니다.
 * 인쇄 작업 목록의 크기는 bufferSize이고 최대 용량 capacities 만큼 문서를 담을 수 있습니다.
 *
 * 만약, 인쇄 작업 목록의 크기가 2이고 최대 용량이 10Kib라면 크기가 [7, 4, 5, 6] Kib인 문서들이 최단 시간 안에 순서대로 모두 인쇄되는 과정은 다음과 같습니다.
 * 1. 1초가 지나면 인쇄 작업 목록에는 7Kib 크기의 문서가 추가됩니다.
 * 2. 2초일 때 인쇄 작업 목록의 최대 용량이 10Kib이기 때문에 4Kib 문서는 작업 목록에 들어갈 수 없습니다. 동시에 7Kib 문서는 작업 목록에서 1칸 앞으로 이동합니다.
 * 3. 3초일 때 7Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 4Kib 문서는 인쇄 작업 목록에 추가됩니다.
 * 4. 4초일 때 4Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다. 동시에 5Kib 문서는 인쇄 작업 목록에 추가됩니다.
 * 5. 5초일 때 4Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 5Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다. 최대 용량 10Kib 제한으로 6Kib 문서는 인쇄 작업 목록으로 추가될 수 없습니다.
 * 6. 6초일 때 5Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다. 동시에 6Kib 문서가 인쇄 작업 목록에 추가됩니다.
 * 7. 7초일 때 6Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.
 * 8. 8초일 때 6Kib 문서가 마지막으로 인쇄됩니다.
 *
 * 위 예시에서와 같이 모든 문서가 출력되는데 걸리는 최소 시간은 8초가 걸립니다.
 * 김코딩이 가지고 있는 프린터의 제한사항인 인쇄 작업 목록의 크기 bufferSize, 최대 용량 capacities가 주어집니다. 인쇄할 문서의 크기가 나열된 배열 documents가 모두 인쇄되는데 걸리는 최소 시간을 반환하는 솔루션을 만들어 주세요.
 * */

/**
 * 입력
 * 인자1: bufferSize
 * int 타입의 인쇄 작업 목록 크기
 * 인자 2: capacities
 * int 타입의 인쇄 작업 목록에 추가될 수 있는 최대 용량
 * 인자 3: documents
 * int 타입을 요소로 갖는 문서 크기가 나열된 배열
 * */
class QueuePrinter{

    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {

        // 10이라면 크기가 [7, 4, 5, 6]
        int time = 0;
        boolean isPrint = true;
        Queue<Integer> queue = new LinkedList<>();

     /*   for (int i=0; i<documents.length; i++){
            // 큐에 문서 넣기 (조건에 따라)
            // 조건 1. 버퍼 사이즈 이하로 큐 사이즈
            //     2. 큐에 있는 애들 + 다음 거 합이 capacity 이하면
            // 삽입
            if(queue.size()<=bufferSize && (queue.stream().reduce(0,Integer::sum)+ documents[i])<=capacities) {
                queue.add(documents[i]);
                isPrint = true;
            }
            // 큐에서 프린트 하기(조건에 따라)
            //  조건 1. isPrint가 true(문서 들어왔음->한 턴 지난거
            else if (isPrint) {
                queue.remove();
                isPrint=false;
            }else{
                i--;
                time++;
            }
            time++;

        }*/





        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.stream(documents).boxed().collect(Collectors.toList()));

        Iterator<Integer> it = Arrays.stream(documents).iterator();
        queue.add(it.next());

        while (!linkedList.isEmpty() && !queue.isEmpty()){
            if(isPrint){
                time++;
                queue.remove();
                isPrint = false;
            }else {
                isPrint = true;
            }

            if(queue.size()<=bufferSize){
                if(queue.stream().reduce(0,Integer::sum)+linkedList.peek()<capacities)
                    queue.add(linkedList.poll());

            }
            System.out.println(it);
        }

        return time;
    }
}

class TreeImplementation{
    private String value;
    private ArrayList<TreeImplementation> children;

    public TreeImplementation() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public TreeImplementation(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    //setter, getter
    public void setValue(String data) {
        this.value = data;
    }
    public String getValue() {      //현재 노드의 데이터를 반환
        return value;
    }

    // addChildNode() :
    public void addChildNode(TreeImplementation node) {
        if(children==null) children = new ArrayList<>();
        children.add(node);
    }

    public void removeChildNode(TreeImplementation node) {
        String data = node.getValue();

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                if(children.get(i).getValue().equals(data)) {
                    children.remove(i);
                    return;
                }
                if(children.get(i).children != null) children.get(i).removeChildNode(node);
            }
        }
    }

    public ArrayList<TreeImplementation> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        boolean check;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data, false);
                if(check) return true;
            }
        }
        return false;
    }

    public boolean contains(String data, boolean check) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                check = children.get(i).contains(data, check);
            }
        }
        return check;
    }
}

class BSTImplement {
    // 트리를 구성하는 노드 클래스입니다.
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        /* 생성자 */
        public Node(int data) {
            this.setData(data);
            setLeft(null);
            setRight(null);
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    //이진 탐색 트리의 클래스입니다.
    public static class binarySearchTree {
        public Node root;

        public binarySearchTree(){
            root = null;
        }

        // tree에 value를 추가합니다.
        public void insert(int data) {
            Node newNode = new Node(data); // 왼쪽, 오른쪽 자식 노드가 null 이며 data 의 값이 저장된 새 노드 생성
            if (root == null) {// 루트 노드가 없을때, 즉 트리가 비어있는 상태일 때,
                root = newNode;
                return;
            }
            if(root.data == data) return;   //중복일때 정지

            Node currentNode = root;
            Node parentNode = null;

            while (true) {
                parentNode = currentNode;

                if (data < currentNode.getData()) { // 해당 노드보다 작을 경우
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(newNode);
                        return;
                    }else if(currentNode.data == newNode.data) return;
                } else { // 해당 노드보다 클 경우
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }else if(currentNode.data == newNode.data) return;
                }
            }
        }

        // tree의 value값을 탐색합니다.
        public boolean contains(int data) {
            Node currentNode = root;
            while (currentNode != null) {
                // 찾는 value값이 노드의 value와 일치한다면, true를 리턴합니다.
                if (currentNode.data == data) {
                    return true;
                }

                if (currentNode.data > data) {
                    // 찾는 value값이 노드의 value 보다 작다면, 현재 노드를 left로 변경후 다시 반복합니다.
                    currentNode = currentNode.left;
                }else {
                    // 찾는 value값이 노드의 value 보다 크다면, 현재 노드를 right로 변경후 다시 반복합니다.
                    currentNode = currentNode.right;
                }
            }
            return false;
        }

  /*
	트리의 순회에 대해 구현을 합니다.
  지금 만드려고 하는 이 순회 메서드는 단지 순회만 하는 것이 아닌, 함수를 매개변수로 받아 콜백 함수에 값을 적용시킨 것을 순회해야 합니다.
  전위 순회를 통해 어떻게 탐색하는지 이해를 한다면 중위와 후위 순회는 쉽게 다가올 것입니다.
	*/

        // 이진 탐색 트리를 전위 순회하는 메서드를 만듭니다.
        public ArrayList<Integer> preorderTree(Node root, int depth, ArrayList<Integer> list) {    //전위 순회
            if (root != null) {
                list.add(root.getData());
                preorderTree(root.getLeft(), depth + 1, list);
                preorderTree(root.getRight(), depth + 1, list);
            }
            return list;
        }

        public ArrayList<Integer> inorderTree(Node root, int depth, ArrayList<Integer> list) { //중위 순회
            //TODO: 전위 순회를 바탕으로 중위 순회를 구현하세요.
            if(root!=null){
                inorderTree(root.getLeft(), depth + 1, list);
                list.add(root.getData());
                inorderTree(root.getRight(), depth + 1, list);
            }
            return list;
        }

        public ArrayList<Integer> postorderTree(Node root, int depth, ArrayList<Integer> list) {   //후위 순회
            //TODO: 전위 순회를 바탕으로 후위 순회를 구현하세요.
            if(root!=null){
                postorderTree(root.getLeft(), depth + 1, list);
                postorderTree(root.getRight(), depth + 1, list);
                list.add(root.getData());
            }
            return list;
        }
    }
}

class GraphAdjacencyMatrixImplement{

    public int[][] createMatrix(int[][] edges) {
        int[][] graph;
        int edgeLength= 0;

        for (int i=0; i<edges.length; i++){
            for (int j=0; j<edges[i].length; j++)
                if(edgeLength<edges[i][j])
                    edgeLength = edges[i][j];
        }

        graph = new int[edgeLength+1][edgeLength+1];

        for (int i =0; i<edges.length; i++){
            if(edges[i][2]==0)
                graph[edges[i][0]][edges[i][1]] = 1;
            else if (edges[i][2]==1) {
                graph[edges[i][0]][edges[i][1]] = 1;
                graph[edges[i][1]][edges[i][0]] = 1;
            }
        }

        return graph;
    }

}

class GraphFindDirection{

    public boolean getDirections(int[][] matrix, int from, int to) {
        return true;
    }

}

