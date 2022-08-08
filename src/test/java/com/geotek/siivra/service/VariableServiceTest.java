package com.geotek.siivra.service;

import com.geotek.siivra.repository.IVariableRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VariableServiceTest {

    @MockBean
    IVariableRepository iVariableRepository;

    @Mock
    IVariableService iVariableService;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testGetAllVariable() {
    }

    @Test
    public void testExtractAllVariable() {
    }

    @Test
    public void testGetVariable() {
    }

   /** @Test
    public void testAddVariable() {
        Mockito.when(iVariableRepository.save(Mockito.any(Variable.class))).thenReturn(null);
        VariableDTO variableDTO = new VariableDTO();
        Variable variable = new Variable();
        variableDTO.setNombre("nueva variable");
        variableDTO.setAlmacenarGeografia("12");

        try {
            iVariableService.addVariable(variableDTO, variableDTO.getAuditoria());
        } catch (Exception e) {
            fail("Should not have thrown any exception");
        }
    }*/

    @Test
    public void testUpdateVariable() {
    }

    @Test
    public void testDeleteVariable() {
    }
}