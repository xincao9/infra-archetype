#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.dto;

import lombok.Data;

@Data
public class Contributor {
    private String login;
    private int contributions;
}
