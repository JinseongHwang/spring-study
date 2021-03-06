package spring.springstudy.domain;

public class Member {

    private Long id; // 데이터를 구분하기 위한 시스템 지정 ID
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
