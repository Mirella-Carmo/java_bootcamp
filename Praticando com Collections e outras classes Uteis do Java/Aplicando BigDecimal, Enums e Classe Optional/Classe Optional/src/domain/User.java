package domain;
public record User<SexEnum>(String name, int age, SexEnum sex) {
}
