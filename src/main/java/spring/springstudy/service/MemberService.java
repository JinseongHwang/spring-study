package spring.springstudy.service;

import org.springframework.stereotype.Service;
import spring.springstudy.domain.Member;
import spring.springstudy.repository.MemberRepository;
import spring.springstudy.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // 여기서 직접 new를 하지 않고 외부에서 가져오는 것을 DI(Dependency Injection)라고 한다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 허용하지 않는다.
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { // 이미 존재한다면 throw를 한다.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        // isPresent랑 헷갈려서 한참 헤맸다. 주의하자.
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
