package pl.kurylek.utils.nullsafe;

import static org.fest.assertions.Assertions.assertThat;
import static pl.kurylek.utils.nullsafe.NullSafeUtils.nullSafe;
import static pl.kurylek.utils.nullsafe.NullSafeUtils.nullSafeToString;
import static pl.kurylek.utils.tests.stub.hero.HeroProfiledBuilder.aCaptainAmerica;

import org.junit.Test;

import pl.kurylek.utils.nullsafe.OnNullBehavior;
import pl.kurylek.utils.tests.stub.hero.Hero;

public class NullSafeUtilsTest {

    private static final int ZERO = 0;
    private static final Object NULL_OBJECT = null;
    private static final Integer NULL_INTEGER = null;
    private static final Hero NULL_HERO = null;

    @Test
    public void shouldToStringNotNullObject() {
	// given
	Hero captainAmerica = aCaptainAmerica().build();

	// when
	String result = nullSafeToString(captainAmerica);

	// then
	assertThat(result).isEqualTo(captainAmerica.toString());
    }

    @Test
    public void shouldToStringBeEmptyStringOnNullObject() {
	// when
	String result = nullSafeToString(NULL_HERO);

	// then
	assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnSameHeroWhenPassedIsNotNull() {
	// given
	Hero captainAmerica = aCaptainAmerica().build();

	// when
	Hero result = nullSafe(captainAmerica, new OnNullBehavior<Hero>() {

	    @Override
	    public Hero onNull() {
		return new Hero();
	    }
	});

	// then
	assertThat(result).isSameAs(captainAmerica);
    }

    @Test
    public void shouldReturnNewHeroWhenPassedIsNull() {
	// when
	Hero result = nullSafe(NULL_HERO, new OnNullBehavior<Hero>() {

	    @Override
	    public Hero onNull() {
		return new Hero();
	    }
	});

	// then
	assertThat(result).isNotNull().isInstanceOf(Hero.class);
    }

    @Test
    public void shouldReturnNewObjectWhenPassedIsNull() {
	// when
	Object result = nullSafe(NULL_OBJECT, new OnNullBehavior<Object>() {

	    @Override
	    public Object onNull() {
		return new Object();
	    }
	});

	// then
	assertThat(result).isNotNull();
    }

    @Test
    public void shouldReturnZeroWhenPassedIntegerIsNull() {
	// when
	Integer result = nullSafe(NULL_INTEGER, new OnNullBehavior<Integer>() {

	    @Override
	    public Integer onNull() {
		return 0;
	    }
	});

	// then
	assertThat(result).isEqualTo(ZERO);
    }
}