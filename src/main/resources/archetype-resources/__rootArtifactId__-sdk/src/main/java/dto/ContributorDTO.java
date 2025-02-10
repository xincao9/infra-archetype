#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto;

import lombok.Data;

@Data
public class ContributorDTO {
    private String login;
    private int contributions;
}
