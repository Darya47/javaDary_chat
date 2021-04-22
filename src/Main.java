public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик");
        Cat mursik = new Cat("Мурзик");
        Cat vasya = new Cat("Вася");
        mursik = barsik;
        System.out.println(vasya.equals(barsik));
        mursik.setNickName("Гоша");
        System.out.println(barsik.getNickName());
    }
}
class Cat{
    private String nickName;
    public Cat (String nickName){
        this.nickName = nickName;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    public String getNickName (){
        return nickName;
    }
    public boolean equals(Cat cat) {
        return (this.nickName.equals(cat.getNickName()));
    }

}