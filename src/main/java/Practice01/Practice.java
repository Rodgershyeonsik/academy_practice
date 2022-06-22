package Practice01;

public class Practice {
    public static void main(String[] args) {
        //모금 상자 개체 얻기
        CollectionBox cb = CollectionBox.getInstance();

        //CollectionBox imitation = new CollectionBox();

        //5명의 백만장자 객체 생성
        MultiMillionaire mm1 = new MultiMillionaire(cb);
        MultiMillionaire mm2 = new MultiMillionaire(cb);
        MultiMillionaire mm3 = new MultiMillionaire(cb);
        MultiMillionaire mm4 = new MultiMillionaire(cb);
        MultiMillionaire mm5 = new MultiMillionaire(cb);


        //모금 시작
        mm1.start();
        mm2.start();
        mm3.start();
        mm4.start();
        mm5.start();

        //모든 사람의 모금이 끝날 때까지 기다립니다.
        try {
            mm1.join();
            mm2.join();
            mm3.join();
            mm4.join();
            mm5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 모금 총액 발표
        System.out.println("모금 총액: " + cb.getTotalAmount() + "원");
    }

}

//부자 클래스
class MultiMillionaire extends Thread {
    private final CollectionBox cb;
    //모금 상자 인스턴스 필드 정의

    //모금 상자 객체를 인수로 받는 생성자 정의
    public MultiMillionaire(final CollectionBox cb) {
        this.cb = cb;
    }

    //run 메서드 재정의, for문 100만 번, 모금상자 1원 모금
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            cb.contribute(1);
        }
    }
}

class CollectionBox {
    //총 모금을 나타내는 인스턴스 필드
    private int totalAmount;
    static CollectionBox instance;

    private CollectionBox() {
    }

    public static CollectionBox getInstance() {
        if (instance == null) {
            instance = new CollectionBox();
        }
        return instance;
    }

    //기부를 위한 contribute 메소드 정의, 인수 int형, 리턴값 없음
    public synchronized void contribute(int donation) {
        this.totalAmount += donation;
    }

    //총 모금액 얻기 위한 getTotalAmount 메소드
    public int getTotalAmount() {
        return this.totalAmount;
    }
}

