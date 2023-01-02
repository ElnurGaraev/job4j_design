package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleNameIsRacer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Racer");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsRacer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        store.add(new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Racer");
    }

    @Test
    void whenReplaceThenRoleNameIsMechanic() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        store.replace("1", new Role("1", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Mechanic");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        store.replace("10", new Role("10", "Mechanic"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Racer");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleNameIsRacer() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Racer");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        boolean rsl = store.replace("1", new Role("1", "Mechanic"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        boolean rsl = store.replace("10", new Role("10", "Mechanic"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Racer"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }

}