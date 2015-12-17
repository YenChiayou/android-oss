package com.kickstarter.ui.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.kickstarter.R;
import com.kickstarter.models.Project;
import com.kickstarter.ui.viewholders.KSViewHolder;
import com.kickstarter.ui.viewholders.ProjectContextViewHolder;
import com.kickstarter.ui.viewholders.ProjectSocialViewHolder;

import java.util.Collections;

public final class ProjectSocialAdapter extends KSAdapter {
  private final Delegate delegate;

  public interface Delegate extends ProjectContextViewHolder.Delegate {}

  public ProjectSocialAdapter(final @NonNull Delegate delegate) {
    this.delegate = delegate;
  }

  @Override
  protected int layout(final @NonNull SectionRow sectionRow) {
    if (sectionRow.section() == 0) {
      return R.layout.project_context_view;
    } else {
      return R.layout.project_social_view;
    }
  }

  public void takeProject(final @NonNull Project project) {
    data().clear();
    data().add(Collections.singletonList(project));
    data().add(project.friends());
    notifyDataSetChanged();
  }

  @Override
  protected KSViewHolder viewHolder(@LayoutRes int layout, final @NonNull View view) {
    if (layout == R.layout.project_context_view) {
      return new ProjectContextViewHolder(view, delegate);
    } else {
      return new ProjectSocialViewHolder(view);
    }
  }
}
