package com.example.springbootactivemq.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WikiData {
    @PrimaryKey
    private Long id;
    private String type;
    private String title;
    private String title_url;
    private String comment;
    private String user;
    private String wiki;
}
