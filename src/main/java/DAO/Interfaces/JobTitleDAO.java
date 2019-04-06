package DAO.Interfaces;

import ObjectModel.JobTitlesEnum;

public interface JobTitleDAO {
    public void insert(JobTitlesEnum jobTitle);
    public void delete(JobTitlesEnum jobTitle);
}
